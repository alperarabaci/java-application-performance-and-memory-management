package main;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * https://github.com/openjdk/jmh/tree/master/jmh-samples/src/main/java/org/openjdk/jmh/samples
 * @author alper
 *
 */
public class NumberChecker {

	public Boolean isPrime1(Integer testNumber) {
		for (Integer i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}	
	
	public Boolean isPrime2(int testNumber) {
		int maxToCheck = (int) Math.sqrt(testNumber);
		for (int i = 2; i <= maxToCheck; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}

	@Benchmark
	public void version1() {
		for (int i = 0; i < 50_000; i++) {
			isPrime1(i);
		}
	}
	
	@Benchmark
	public void version2() {
		for (int i = 0; i < 50_000; i++) {
			isPrime2(i);
		}
	}
}
