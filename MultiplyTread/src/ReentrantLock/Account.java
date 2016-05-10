/*
 * 
 */
package ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 *
 */
public class Account {
	
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	private String accountNo;
	private double balance;

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [lock=" + lock + ", cond=" + cond + ", accountNo=" + accountNo + ", balance=" + balance
				+ ", flag=" + flag + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	private boolean flag = false;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return this.balance;
	}

	/**
	 * 取钱
	 * 
	 * @param drawAmount
	 */
	public void Draw(double drawAmount) {
		lock.lock();
		try {
			if (!flag) {// 无存款
				cond.await();
			} else {
				if (drawAmount > this.balance) {
					System.out.println(Thread.currentThread().getName() + ":目前余额：" + this.balance + ",本次取：" + drawAmount
							+ ",余额不足");
				} else {
					this.balance -= drawAmount;
					System.out.println(Thread.currentThread().getName() + "目前余额：" + this.balance + ",本次取：" + drawAmount
							+ ",余额:" + this.balance);
					this.flag = false;
					cond.signalAll();
				}
			}

		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void deposit(double depositAmount) {
		lock.lock();
		try {
			if (flag) {
				cond.await();
			} else {
				this.balance += depositAmount;
				System.out
						.println(Thread.currentThread().getName() + ":本次存款：" + depositAmount + ",当前余额:" + this.balance);
				flag = true;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
}
