package main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main21_113 {

	private static final int BOOK_SIZE = 1_0000_000;
	private static final int MAP_INIT_SIZE = 500_0000;

	/**
	 * Use jmh benchmark instead of this results
	 * @param args
	 */
	public static void main(String[] args) {
		Book book = new Book(2, "Jane Eyre", "Charlotte Bronte", 14.99);
		System.out.println(book.hashCode());//422392391
	}

	/**
	 * 1M: Elapsed time was 1341 ms.
	 * 2M: Elapsed time was 2985 ms.
	 * 
	 */
	public static void map() {
		Date start = new Date();

		Map<Book, Double> books = new HashMap<>(MAP_INIT_SIZE, 0.9f);
		for (int i = 0; i < BOOK_SIZE; i++) {
			books.put(new Book(i, "Jane Eyre", "Charlotte Bronte", 14.99), 14.99);
		}

		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) + " ms.");
	}

	
}
