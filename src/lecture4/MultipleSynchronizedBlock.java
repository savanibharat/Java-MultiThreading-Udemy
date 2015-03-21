package lecture4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * If we add synchronized keyword to method stageOne() and stageTwo() then it will work fine.
 * But one thread will be able to access only one method so we unnecessarily locking another method as well.
 * For this we built 2 objects lock1 and lock2 of Object Class and wrie synchronized block on those objects.
 * Two thread can run one method at the same time.
 * */
public class MultipleSynchronizedBlock {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	Random r = new Random(1000);
	
	Object lock1=new Object();
	Object lock2=new Object();

	public synchronized void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(r.nextInt());
		}
	}

	public synchronized void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(r.nextInt());	
		}
	}

	public void process() {
		for (int i = 0; i < 500; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {

		System.out.println("Starting...");

		long start = System.currentTimeMillis();

		process();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();

		System.out.println("Time taken " + (end - start));

		System.out.println("list1 size " + list1.size() + " :: list2 size "+ list2.size());
	}
}
