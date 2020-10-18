package main.gc;

import java.util.ArrayList;
import java.util.List;

/**
 *  Chapter 15 - Garbage Collector tuning & selection
 *  
 *  vm arguments: -Xmx10m -verbose:gc
 *  
 *  logs: (comes from -verbose:gc)
	[0.007s][info][gc] Using G1
	[0.172s][info][gc] GC(0) Pause Young (Normal) (G1 Evacuation Pause) 4M->0M(10M) 1.538ms
	[0.190s][info][gc] GC(1) Pause Young (Normal) (G1 Evacuation Pause) 4M->0M(10M) 1.348ms
	[0.205s][info][gc] GC(2) Pause Young (Normal) (G1 Evacuation Pause) 3M->0M(10M) 0.313ms
	[0.224s][info][gc] GC(3) Pause Young (Normal) (G1 Evacuation Pause) 4M->0M(10M) 0.209ms
	[0.244s][info][gc] GC(4) Pause Young (Normal) (G1 Evacuation Pause) 4M->0M(10M) 0.198ms
	[0.269s][info][gc] GC(5) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.249ms
	[0.293s][info][gc] GC(6) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.226ms
	[0.317s][info][gc] GC(7) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.301ms
	[0.340s][info][gc] GC(8) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.296ms
	[0.365s][info][gc] GC(9) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.314ms
	[0.389s][info][gc] GC(10) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.222ms
	[0.413s][info][gc] GC(11) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.198ms
	[0.438s][info][gc] GC(12) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.245ms
	[0.462s][info][gc] GC(13) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.247ms
	[0.487s][info][gc] GC(14) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.226ms
	[0.511s][info][gc] GC(15) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.270ms
	[0.535s][info][gc] GC(16) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.247ms
	[0.560s][info][gc] GC(17) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.211ms
	[0.585s][info][gc] GC(18) Pause Young (Normal) (G1 Evacuation Pause) 5M->0M(10M) 0.237ms
	...
	[67.345s][info][gc] GC(3278) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.281ms
	[67.365s][info][gc] GC(3279) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.248ms
	[67.386s][info][gc] GC(3280) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.220ms
	[67.406s][info][gc] GC(3281) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.239ms
	[67.427s][info][gc] GC(3282) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.284ms
	[67.447s][info][gc] GC(3283) Pause Young (Normal) (G1 Evacuation Pause) 6M->2M(10M) 0.284ms
 *  
 * @author alper
 *
 */
public class Main15_65 {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<>();
		while(true) {
			//add 100
			Customer c = new Customer("Alper");
			customers.add(c);
			
			//remove 10 we gonna watch gc.
			if(customers.size()>100) {
				for (int i = 0; i < 10; i++) {
					customers.remove(0);
				}
			}
		}
	}
	
}
