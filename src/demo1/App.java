package demo1;

public class App {
	
	static class Runner extends  Thread{
		
		public void run(){
			
			for(int i = 0; i < 10; i++){
				System.out.println("Hello" + i);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		/**
		 * Thread = A seperate operating system process
		 * which can run concurrently with other threads.
		 */
		
		Runner runner1 = new Runner();
		runner1.start();
		
		Runner runner2 = new Runner();
		runner2.start();

	}

}
