package stringconcat;

import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;

public class StringBuilderBenchmarking {

	private static String[] firstNames = { "Adam", "Bill", "Carey", "Delia", "Emma", "Frank", "Gillian", "Harold" };
	private static String[] middleNames = { "Irene", "Jill", "Kevin", "Leanne", "Mike", "Nick", "Orphelia", "Pete" };
	private static String[] surnames = { "Green", "White", "Black", "Brown", "Purple", "Yellow", "Pink", "Orange" };

	@Benchmark
	public static void benchmarkingRunner() {
		StringBuilderBenchmarking sb = new StringBuilderBenchmarking();
		sb.run();
	}
	
	public void run() {
		System.out.println("warm up period starting");
		for (int i = 1; i < 50000; i++)
			generateNames();

		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("measurement period starting");

		long start = System.currentTimeMillis();
		for (int i = 1; i < 500000; i++)
			generateNames();
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to generate 500,000 names: " + (end - start) + " milliseconds");
	}
	
	private String generateNames() {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		sb.append(firstNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(middleNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(surnames[r.nextInt(8)]);
		sb.append(" and ");
		sb.append(firstNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(middleNames[r.nextInt(8)]);
		sb.append(" ");
		sb.append(surnames[r.nextInt(8)]);
		return sb.toString();
	}
}
