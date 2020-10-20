package main;

import java.util.Random;

public class StringBuilderPerformance {
	
	public static void main(String[] args) {
		StringBuilderPerformance p = new StringBuilderPerformance();
		p.run();
	}

	String[] firstNames = { "Adam", "Bill", "Carey", "Delia", "Emma", "Frank", "Gillian", "Harold" };
	String[] middleNames = { "Irene", "Jill", "Kevin", "Leanne", "Mike", "Nick", "Orphelia", "Pete" };
	String[] surnames = { "Green", "White", "Black", "Brown", "Purple", "Yellow", "Pink", "Orange" };

	/**
	 *  warm up period starting
		warm up period done
		measurement period starting
		measurement period done
		time taken to generate 500,000 names: 365 milliseconds
	 * @return
	 */
	private String generateNames1() {
		Random r = new Random();
		String result = firstNames[r.nextInt(8)];
		result = result + " ";
		result = result + middleNames[r.nextInt(8)];
		result = result + " ";
		result = result + surnames[r.nextInt(8)];
		result = result + " and ";
		result = result + firstNames[r.nextInt(8)];
		result = result + " ";
		result = result + middleNames[r.nextInt(8)];
		result = result + " ";
		result = result + surnames[r.nextInt(8)];
		return (result);
	}

	/**
	 *  JMH (jdk8) result: StringBuilderBenchmarking.benchmarkingRunner  thrpt   25  0.892 ±  0.001  ops/s
	 *  JMH (jdk11) result: StringBuilderBenchmarking.benchmarkingRunner  thrpt   25  0.890 ± 0.003  ops/s
	 *  generateNames2 result:
	 *  warm up period starting
		warm up period done
		measurement period starting
		measurement period done
		time taken to generate 500,000 names: 168 milliseconds
	 * @return
	 */
	private String generateNames2() {
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
	
	/**
	 * JMH (jdk8):  StringConcatBenchmarking.benchmarkingRunner   thrpt   25  0.895 ±  0.001  ops/s
	 * JMH (jdk11): StringConcatBenchmarking.benchmarkingRunner   thrpt   25  0.900 ± 0.002  ops/s
	 * generateNames3 result:
	 *  warm up period starting
		warm up period done
		measurement period starting
		measurement period done
		time taken to generate 500,000 names: 144 milliseconds
	 * @return
	 */
	private String generateNames3() {
		Random r = new Random();
		String result = firstNames[r.nextInt(8)] + " " + middleNames[r.nextInt(8)] + " " + surnames[r.nextInt(8)] + " and "
		+ firstNames[r.nextInt(8)] + " " + middleNames[r.nextInt(8)] + " " + surnames[r.nextInt(8)];
		return (result);
	}
	
	public void run() {
		System.out.println("warm up period starting");
		for (int i = 1; i < 50000; i++)
			generateNames2();

		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("measurement period starting");

		long start = System.currentTimeMillis();
		for (int i = 1; i < 500000; i++)
			generateNames2();
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to generate 500,000 names: " + (end - start) + " milliseconds");
	}
}
