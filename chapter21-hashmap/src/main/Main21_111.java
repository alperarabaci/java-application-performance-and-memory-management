package main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main21_111 {

	private static final int BOOK_SIZE = 1_0000_000;
	private static final int MAP_INIT_SIZE = 500_0000;

	/**
	 * Use jmh benchmark instead of this results
	 * @param args
	 */
	public static void main(String[] args) {
		mapWithCapacityAndLoadFactorOptimum();
	}

	/**
	 * 1M: Elapsed time was 1341 ms.
	 * 2M: Elapsed time was 2985 ms.
	 * 
	 */
	public static void mapWithCapacityAndLoadFactor() {
		Date start = new Date();

		Map<Integer, Book> books = new HashMap<>(MAP_INIT_SIZE, 0.9f);
		for (int i = 0; i < BOOK_SIZE; i++) {
			books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
		}

		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}

	/**
	 * 1M: Elapsed time was 1307 ms. ?? mapWithCapacity is still quickest. we should use JMH!
	 */
	public static void mapWithCapacityAndLoadFactorOptimum() {
		Date start = new Date();

		Map<Integer, Book> books = new HashMap<>(BOOK_SIZE, 0.6f);
		for (int i = 0; i < BOOK_SIZE; i++) {
			books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
		}

		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}

	
	/**
	 * 1M: Elapsed time was 1300 ms.
	 * 2M: Elapsed time was 2854 ms. JDKAJSLD JALKSDJ LAJDLJASL
	 */
	public static void mapWithCapacity() {
		Date start = new Date();

		Map<Integer, Book> books = new HashMap<>(MAP_INIT_SIZE);
		for (int i = 0; i < BOOK_SIZE; i++) {
			books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
		}

		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}
	
	/**
	 * 2M: Elapsed time was 3309 ms.
	 * 1M: Elapsed time was 1413 ms.
	 */
	public static void map() {
		Date start = new Date();

		Map<Integer, Book> books = new HashMap<>();
		for (int i = 0; i < BOOK_SIZE; i++) {
			books.put(i, new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99));
		}

		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}
	
}
