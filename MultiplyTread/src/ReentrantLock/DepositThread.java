package ReentrantLock;

public class DepositThread extends Thread {
	private Account account;
	private double depositAmount;

	public DepositThread(String name, Account account, double depositAmount) {
		// TODO Auto-generated constructor stub
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}

}
