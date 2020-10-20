package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * There is a huge gap between jdk 8 and jdk 11
 * @author alper
 *
 */
public class Main20_102 {

	public static void main(String[] args) {
		listWithDefaultCap();
	}

	/**
	 * benchmark score (thrpt): 0.756 ops/s
	 * 
	 * JDK 11
	 * 10000000 => Elapsed time was 811 ms.
	 * 20000000 => Elapsed time was 1548 ms.
	 * 
	 * JDK 8
	 * Elapsed time was 7364 ms.
	 * 
	 */
	public static void listWithDefaultCap() {
		
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 20000000; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
	
	/**
	 * benchmark score (thrpt): 0.906 ops/s
	 * 
	 * JDK 11
	 * Elapsed time was 709 ms.
	 * Elapsed time was 1439 ms.
	 * 
	 * JDK 8
	 * Elapsed time was 20407 ms.
	 */
	public static void listWithInitializeCap() {
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>(20000000);
		for (int i = 0; i < 20000000; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
}
