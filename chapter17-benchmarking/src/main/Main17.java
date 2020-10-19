package main;

public class Main17 {

	/**
	 * -XX:+PrintCompilation
	 * @param args
	 */
	public static void main(String[] args) {
		NumberChecker nc = new NumberChecker();
		// System.out.println(nc.isPrime1(23));
		
		for (int i = 0; i < 10_000; i++) {
			nc.isPrime1(i);
		}

		System.out.println("warmup finished, now measuring.");
		
		long start = System.currentTimeMillis();

		for (int i = 1; i < 50000; i++) {
			nc.isPrime1(i);
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken " + (end - start) + " ms");
	}
}
