package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main20_102_jdk8 {

	public static void main(String[] args) {
		listWithInitializeCap();
	}

	/**
	 * JDK 8
	 * 20000000 => Elapsed time was 7364 ms.
	 * 
	 * 10000000 => Elapsed time was 4448 ms.
	 */
	public static void listWithDefaultCap() {
		
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < 10000000; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
	
	/**
	 * JDK 8
	 * 20000000 => Elapsed time was 20407 ms.
	 * 
	 * 10000000 => Elapsed time was 11385 ms.
	 */
	public static void listWithInitializeCap() {
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>(10000000);
		for (int i = 0; i < 10000000; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
}
