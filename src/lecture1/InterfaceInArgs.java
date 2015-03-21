package lecture1;

public class InterfaceInArgs {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		});
		t1.start();
	}
}
