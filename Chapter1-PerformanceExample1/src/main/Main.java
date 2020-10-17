package main;

import java.util.Date;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//Thread.sleep(20000);
		Date start = new Date();
		System.out.println("Starting work...");
		PrimeNumbers primeNumbers = new PrimeNumbers();
		Integer max = Integer.parseInt(args[0]);
		primeNumbers.generateNumbers(max);
		System.out.println("Finishing work...");
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}

}
