package BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	private BlockingQueue<String> bg;

	public Producer(BlockingQueue<String> bg) {
		this.bg = bg;
	}

	@Override
	public void run() {
		String[] strArr = new String[] { "Java", "Struct", "Spring" };
		for (int i = 0; i < 99999999; i++) {
			System.out.println(getName() + "生产者准备生产要素集合");
			try {
				Thread.sleep(200);
				bg.put(strArr[i % 3]);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			System.out.println(getName() + "生产完成"+bg);
		}
	}
}
