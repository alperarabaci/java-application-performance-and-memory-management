package finalize; 

import java.util.ArrayList;
import java.util.List;

public class Main11Finalize {
	
	/**
	 *  After finalize workder:
	 *  Result is changing at every run...
		This object is being g.c. John74
		This object is being g.c. John99
		This object is being g.c. John98
		This object is being g.c. John97
		This object is being g.c. John96
		This object is being g.c. John95
		This object is being g.c. John94
		This object is being g.c. John93
		This object is being g.c. John92
		This object is being g.c. John91
		This object is being g.c. John90
		This object is being g.c. John89
		This object is being g.c. John88
		This object is being g.c. John87
		This object is being g.c. John86
		
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException 
	{
		Runtime runtime = Runtime.getRuntime();

		long availableBytes = runtime.freeMemory();
		System.out.println("Available memory at start: " + availableBytes / 1024 + "k");

		// let's create lots of objects....
		List<CustomerFinalize> customers = new ArrayList<CustomerFinalize>();
		
		for (int i=0; i<100; i++)
		{
			customers.add(new CustomerFinalize("John"+i));	
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
