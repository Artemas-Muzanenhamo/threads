package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	
	private int id;
	
	public Processor(int id){
		this.id = id;
	}
	
	public void run() {
		System.out.println("Starting: " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed: " + id);
	}
	
}

public class App {
	
	public static void main(String[] args){
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i++){
			exec.submit(new Processor(i));
		}
		
		exec.shutdown();
		
		System.out.println("All tasks submitted");
		
		try {
			exec.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
		
	}

}
