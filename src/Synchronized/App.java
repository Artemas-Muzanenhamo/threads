package Synchronized;



public class App {
	
	private int count = 0;
	
	/**
	 * Synchronized methods enable a simple 
	 * strategy for preventing thread 
	 * interference and memory 
	 * consistency errors
	 */
	public synchronized void increment(){
		count++;
	}

	public static void main(String[] args) {
		
		App app = new App();
		app.doWork();
		
	}
	
	public void doWork(){
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0;i < 10000;i++){
					increment();
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				for(int i = 0;i < 10000;i++){
					increment();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		//to wait for the threads to finish...
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
		
	}

}
