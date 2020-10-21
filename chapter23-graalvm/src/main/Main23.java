package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-20.2.0
 * https://www.graalvm.org/docs/getting-started-with-graalvm/macos/
 * 
 * No any significant improvement?!?!?!
 * Because we don't use GraalVM Native Compilation. :(
 * GraalVM (jdk11): 6050 ms. 
 * Java SE 11 (jdk11): 6221 ms.
 * 
 * 

   with -XX:+PrintCompilation parameter:
   1970  581 %     4       main.Main23::main @ 66 (303 bytes)   made not entrant
   1971  585       3       main.Main23::isPrime (41 bytes)
   1972  586 %     4       main.Main23::isPrime @ 15 (41 bytes)
   1973  587       4       main.Main23::isPrime (41 bytes)
   1975  585       3       main.Main23::isPrime (41 bytes)   made not entrant
   1982  588 %     3       main.Main23::main @ 167 (303 bytes)
   2401  592 %     4       main.Main23::main @ 167 (303 bytes)
   2408  588 %     3       main.Main23::main @ 167 (303 bytes)   made not entrant
   6386  592 %     4       main.Main23::main @ 167 (303 bytes)   made not entrant

 * @author alper
 *
 */
public class Main23 {

	public static boolean isPrime(long testNumber) {
		long maxToCheck = (long) Math.sqrt(testNumber);
		for (long i = 2; i < maxToCheck; i++) {
			if (testNumber % i == 0)
				return false;
		}
		return true;
	}

	/**
	 *  UUIDs generated
		Integers generated
		19588 primes found.
		The largest prime was 999990517
		time taken : 6050 ms.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		long start = System.currentTimeMillis();

		// generate 5m random UUIDs
		List<UUID> uuids = new ArrayList<UUID>();
		for (int i = 0; i < 500000; i++) {
			uuids.add(UUID.randomUUID());
		}

		System.out.println("UUIDs generated");

		// extract the integer parts - using a set to avoid duplicates
		Set<Long> numbersFromUUIDs = new HashSet<Long>();
		for (UUID uuid : uuids) {
			String numberFromUuid = uuid.toString().replaceAll("[^0-9]", "");
			if (numberFromUuid.length() > 9) {
				numberFromUuid = numberFromUuid.substring(0, 9);
			}
			numbersFromUUIDs.add(Long.parseLong(numberFromUuid));
		}

		System.out.println("Integers generated");

		// find the primes
		List<Long> primes = new ArrayList<Long>();
		for (Long l : numbersFromUUIDs) {
			if (isPrime(l)) {
				primes.add(l);
			}
		}

		System.out.println(primes.size() + " primes found.");

		System.out.println("The largest prime was " + Collections.max(primes));

		long stop = System.currentTimeMillis();
		System.out.println("time taken : " + (stop - start) + " ms.");
	}

}
