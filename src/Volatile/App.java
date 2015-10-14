package Volatile;

import java.util.Scanner;

class Processor extends Thread{
	
	//Volatile prevents a thread from caching variables.
	private volatile boolean running = true;
	
	//here we are overriding the run method in the Thread class.
	public void run(){
		
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}

public class App {

	public static void main(String[] args) {
		
		Processor proc1 = new Processor();
		proc1.start(); //tells the thread class to run the code in the RUN() method..
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		proc1.shutdown();

	}

}
