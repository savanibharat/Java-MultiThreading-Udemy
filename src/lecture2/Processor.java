package lecture2;

import java.util.Scanner;

/**
 * This program demonstrates usage of the synchronized keyword
 * 
 * Declaring a volatile Java variable means:
 * 1) The value of this variable will never be cached thread-locally: all reads and writes will go straight to 
 * "main memory";
 * 2) Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.
 * 
 * */
public class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running=false;
	}
	
	/**
	 * In Java this seems to work properly.
	 * But there is a catch. There can be the cases when processor caches the value of running
	 * and keeps the run method running and not entertaining the new value of variable running.
	 * 
	 * There are 2 thread running
	 * 1->Main thread
	 * 2->Extends thread running run method
	 * 
	 * When java tries to optimize the code it assumes that one thread will not modify the data of another thread.
	 * 
	 * To make sure that this code works on all systems we need to use volatile keyword for running variable.
	 * */
	public static void main(String[] args) {
		
		Processor p=new Processor();
		p.start();
		
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		scan.nextLine();
		
		p.shutdown();
		
	}
}
