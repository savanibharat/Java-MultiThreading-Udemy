package lecture1;

public class UseRunnableInterface implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		UseRunnableInterface run1 = new UseRunnableInterface();
		Thread t1 = new Thread(run1);
		t1.start();

		UseRunnableInterface run2 = new UseRunnableInterface();
		Thread t2 = new Thread(run2);
		t2.start();

	}

}
