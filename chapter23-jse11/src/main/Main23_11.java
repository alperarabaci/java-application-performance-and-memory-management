package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
	with -XX:+PrintCompilation parameter:
    325  253 %     3       main.Main23_11::main @ 18 (303 bytes)
    327  254       3       main.Main23_11::main (303 bytes)
    396  255 %     4       main.Main23_11::main @ 18 (303 bytes)
    400  253 %     3       main.Main23_11::main @ 18 (303 bytes)   made not entrant
   1035  255 %     4       main.Main23_11::main @ 18 (303 bytes)   made not entrant
   1096  399 %     3       main.Main23_11::main @ 66 (303 bytes)
   1198  429 %     4       main.Main23_11::main @ 66 (303 bytes)
   1240  399 %     3       main.Main23_11::main @ 66 (303 bytes)   made not entrant
   1265  429 %     4       main.Main23_11::main @ 66 (303 bytes)   made not entrant
   1268  432 %     3       main.Main23_11::main @ 66 (303 bytes)
   1377  433 %     4       main.Main23_11::main @ 66 (303 bytes)
   1412  432 %     3       main.Main23_11::main @ 66 (303 bytes)   made not entrant
   2113  433 %     4       main.Main23_11::main @ 66 (303 bytes)   made not entrant
   2115  480 %     4       main.Main23_11::isPrime @ 15 (41 bytes)
   2116  481       4       main.Main23_11::isPrime (41 bytes)
   2124  482 %     3       main.Main23_11::main @ 167 (303 bytes)
   2563  486 %     4       main.Main23_11::main @ 167 (303 bytes)
   2576  482 %     3       main.Main23_11::main @ 167 (303 bytes)   made not entrant
   6515  486 %     4       main.Main23_11::main @ 167 (303 bytes)   made not entrant
 * @author alper
 *
 */
public class Main23_11 {

	public static boolean isPrime(long testNumber) {
		long maxToCheck = (long) Math.sqrt(testNumber);
		for (long i = 2; i < maxToCheck; i++) {
			if (testNumber % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * UUIDs generated
		Integers generated
		20051 primes found.
		The largest prime was 999975409
		time taken : 6221 ms.
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
