package main; 

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	/**
	 *  
	 	Available memory at start: 260134k
		Available memory  when customers created: 226834k
		Available memory  when customers no longer referenced: 226834k
		Available memory  1 second later: 226834k
		Available memory  after GC command: 9533k
		
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		Runtime runtime = Runtime.getRuntime();

		long availableBytes = runtime.freeMemory();
		System.out.println("Available memory at start: " + availableBytes / 1024 + "k");

		// let's create lots of objects....
		List<Customer> customers = new ArrayList<Customer>();
		
		for (int i=0; i<1_000_000; i++)
		{
			customers.add(new Customer("John"));	
		}
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  when customers created: " + availableBytes / 1024 + "k");
		
		customers = new ArrayList<>();
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  when customers no longer referenced: " + availableBytes / 1024 + "k");
		
		Thread.sleep(1000);

		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  1 second later: " + availableBytes / 1024 + "k");

		System.gc();
		
		availableBytes = runtime.freeMemory();
		System.out.println("Available memory  after GC command: " + availableBytes / 1024 + "k");
	}
	
}
