package Latches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	
	public Processor(CountDownLatch latch){
		this.latch = latch;
	}
	public void run(){
		System.out.println("Started");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latch.countDown();
	}
}

public class App {

	public static void main(String[] args) {
		
		/**
		 * A synchronization aid that allows 
		 * one or more threads to wait until 
		 * a set of operations being performed 
		 * in other threads completes.
		 */
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService exec = Executors.newFixedThreadPool(3);
		
		for(int i = 0; i < 3; i++){
			exec.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed");

	}

}
