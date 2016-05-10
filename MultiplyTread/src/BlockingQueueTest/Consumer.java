package BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

/**
 * 
 */

public class Consumer extends Thread {
	BlockingQueue<String> bg;

	public Consumer(BlockingQueue<String> bg) {
		// TODO Auto-generated constructor stub
		this.bg = bg;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + "消费者准备消费集合 元素");
			for (int i = 0; i < 99999999; i++) {
				try {
					Thread.sleep(200);
					bg.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					 e.printStackTrace();
				}
				System.out.println(getName() + "消费完成：" + bg);
			}
		}
	}
}
