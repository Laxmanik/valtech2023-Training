package CoreJava.Day3;

import java.util.Iterator;

public class ThreadTest {
	
	public static class printerTread extends Thread{
		
		@Override
		public void run() {
			
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread()+" "+i); //prints current thread
				
			}
		
		}
	}
	
	public static class PrinterThreadByInterface implements Runnable{

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread()+" "+i); //prints current thread
				
			} 
			
		}
		
	}
	
	public static void main(String[] args) {
	
		new printerTread().start(); //thread is created and started
		new printerTread().start();
		new Thread(new PrinterThreadByInterface()).start();
		
		new Thread(new Runnable() {  // constructor of thread takes runnable interface
			
			@Override
			public void run() {
				
			}
		}).start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread()+" "+i);
			
		}
	}

}
