package main.gc;

import java.util.ArrayList;
import java.util.List;

/**
 *  Chapter 15 - Garbage Collector tuning & selection
 *  
 *  vm arguments: -Xmx10m -verbose:gc
 *  
 *  logs: (comes from -verbose:gc)

 *  
 * @author alper
 *
 */
public class Main15_66 {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		while(true) {
			//add 100
			Customer c = new Customer("Alper");
			customers.add(c);
			
			//remove 10 we gonna watch gc.
			if(customers.size()>10_000) {
				for (int i = 0; i < 5_000; i++) {
					customers.remove(0);
				}
			}
		}
	}
	
}
