package BlockingQueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> bg = new ArrayBlockingQueue<String>(1);
		new Producer(bg).start();
		new Producer(bg).start();
		new Producer(bg).start();
		new Consumer(bg).start();
	}

}
