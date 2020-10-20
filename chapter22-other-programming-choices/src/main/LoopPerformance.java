package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LoopPerformance {

	public static void main(String[] args) {
		LoopPerformance p = new LoopPerformance();
		p.run();
	}

	String[] firstNames = { "Adam", "Bill", "Carey", "Delia", "Emma", "Frank", "Gillian", "Harold" };
	String[] middleNames = { "Irene", "Jill", "Kevin", "Leanne", "Mike", "Nick", "Orphelia", "Pete" };
	String[] surnames = { "Green", "White", "Black", "Brown", "Purple", "Yellow", "Pink", "Orange" };

	private String generateName() {
		Random r = new Random();
		String result = firstNames[r.nextInt(8)] + " " + middleNames[r.nextInt(8)] + " " + surnames[r.nextInt(8)];
		return (result);
	}

	/**
	 * warm up period starting 86248944 warm up period done measurement period
	 * starting 86248944 measurement period done time taken to loop through
	 * 5,000,000 strings: 34 milliseconds
	 * 
	 * @param names
	 * @return
	 */
	private long calculateLength1(List<String> names) {
		long length = 0;
		for (String name : names) {
			long nameLength = name.length();
			if (nameLength > 9)
				length = length + name.length();
		}
		System.out.println(length);
		return length;
	}

	/**
	 * warm up period starting 86245585 warm up period done measurement period
	 * starting 86245585 measurement period done time taken to loop through
	 * 5,000,000 strings: 35 milliseconds
	 * 
	 * @param names
	 * @return
	 */
	private long calculateLength2(List<String> names) {
		long length = 0;

		length = names.stream().mapToInt(s -> s.length()).filter(l -> l > 9).sum();
		System.out.println(length);
		return length;
	}

	/**
	 * warm up period starting
		86257449
		warm up period done
		measurement period starting
		86257449
		measurement period done
		time taken to loop through 5,000,000 strings: 211 milliseconds
	 * @param names
	 * @return
	 */
	private long calculateLength3(List<String> names) {
		long length = 0;

		length = names.stream().flatMapToInt(s -> IntStream.of(s.length() > 9 ? s.length() : null)).sum();
		System.out.println(length);
		return length;
	}
	
	/**
	 * warm up period starting
		86259424
		warm up period done
		measurement period starting
		86259424
		measurement period done
		time taken to loop through 5,000,000 strings: 17 milliseconds
	 * @param names
	 * @return
	 */
	private long calculateLength4(List<String> names) {
		long length = 0;

		length = names.parallelStream().mapToInt(s -> s.length()).filter(l -> l > 9).sum();
		System.out.println(length);
		return length;
	}

	public void run() {

		List<String> names = new ArrayList<String>();
		for (int i = 1; i < 5000000; i++)
			names.add(generateName());

		System.out.println("warm up period starting");
		calculateLength4(names);

		System.out.println("warm up period done");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		System.out.println("measurement period starting");
		long start = System.currentTimeMillis();
		calculateLength4(names);
		long end = System.currentTimeMillis();
		System.out.println("measurement period done");
		System.out.println("time taken to loop through 5,000,000 strings: " + (end - start) + " milliseconds");
	}
}
