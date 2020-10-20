package listbenchmarking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

public class ListBenchmarking {

	private static final int TOTAL = 10000000;
	
	@Benchmark
	public static void listWithDefaultCap() {
		
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>();
		for (int i = 0; i < TOTAL; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
	
	@Benchmark
	public static void listWithInitializeCap() {
		Date start = new Date();
		
		List<Book> books = new ArrayList<Book>(TOTAL);
		for (int i = 0; i < TOTAL; i++) {
			books.add(new Book(i,"Jane Eyre","Charlotte Bronte",14.99));
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was " + (end.getTime() - start.getTime()) +" ms.");
	}
	
}
