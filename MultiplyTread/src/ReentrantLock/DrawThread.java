package ReentrantLock;

public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount) {
		// TODO Auto-generated constructor stub
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			account.Draw(drawAmount);
		}
	}
}
