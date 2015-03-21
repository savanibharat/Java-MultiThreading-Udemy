package lecture1;

public class UseThreadClass extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}*/
		}
	}

	public static void main(String[] args) {
		
		UseThreadClass runner1=new UseThreadClass();
		runner1.start();
		
		UseThreadClass runner2=new UseThreadClass();
		runner2.start();
	}
}
