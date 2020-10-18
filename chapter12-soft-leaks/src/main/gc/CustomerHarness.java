package main.gc;
public class CustomerHarness {
	
	/**
	 * vm arguments: -Xmx50m
	 * 
	 * Sun Oct 18 11:27:41 EET 2020 Customers in queue : 19181 of 19182
		Available memory: 5600k
		Sun Oct 18 11:27:46 EET 2020 Customers in queue : 38407 of 38414
		Available memory: 4043k
		Sun Oct 18 11:27:51 EET 2020 Customers in queue : 58090 of 58094
		Available memory: 2516k
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-4"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-6"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-2"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-1"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-8"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-3"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-0"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-7"
		
		Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "Thread-5"
	 * @param args
	 */
	public static void main(String[] args)  {
		CustomerManager cm = new CustomerManager();
		GenerateCustomerTask generateTask = new GenerateCustomerTask(cm);
		ProcessCustomerTask processTask = new ProcessCustomerTask(cm);
		
		for (int user = 0; user < 10; user++) {
			Thread t = new Thread(generateTask);
			t.start();
		}
		Thread t = new Thread(processTask);
		t.start();
		
		//main thread is now acting as the monitoring thread
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cm.howManyCustomers();
			System.out.println("Available memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
			
		}
	}

}
