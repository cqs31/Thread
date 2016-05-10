package ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account= new Account("1234567",0);
		new DrawThread("取1", account, 20).start();
		new DepositThread("存1",account , 50).start();
		new DepositThread("存2",account , 20).start();
		new DepositThread("存3",account , 30).start();
	}

}
