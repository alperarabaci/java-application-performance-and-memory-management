package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main10 {

	/**
	 * First attempt (ch43):
	 * vm arguments: -XX:+PrintStringTableStatistics (8718ms.)
	 * 
	 * Second attempt (ch44):
	 * vm arguments: -XX:+PrintStringTableStatistics -XX:StringTableSize=120121 (5077 ms.)
	 * 
	 * For 3.5 million I got this message: statistics unavailable at this moment
	 * So I decrease i to 3 million
	 * @param args
	 */
	public static void main(String[] args) {
		
		Date start = new Date();
		
		List<String> list = new ArrayList<>();
		for (Integer i = 0; i < 3_000_000; i++) {
			String s = i.toString().intern();
			list.add(s);
		}
		
		Date end = new Date();
		System.out.println("Elapsed time was:" + (end.getTime()-start.getTime())+ " ms.");
		
		/**
		 * 
			Elapsed time was:8718 ms.
			StringTable statistics:
			Number of buckets       :     65536 =    524288 bytes, each 8
			Number of entries       :   3004903 =  48078448 bytes, each 16
			Number of literals      :   3004903 = 144311240 bytes, avg  48.025
			Total footprsize_t         :           = 192913976 bytes
			Average bucket size     :    45.851
			Variance of bucket size :   199.142
			Std. dev. of bucket size:    14.112
			Maximum bucket size     :        92
		 */
		
		//after change bucket size to:
		/**
		 * Elapsed time was:5077 ms.
			StringTable statistics:
			Number of buckets       :    131072 =   1048576 bytes, each 8
			Number of entries       :   3004903 =  48078448 bytes, each 16
			Number of literals      :   3004903 = 144311240 bytes, avg  48.025
			Total footprsize_t         :           = 193438264 bytes
			Average bucket size     :    22.926
			Variance of bucket size :    51.024
			Std. dev. of bucket size:     7.143
			Maximum bucket size     :        48
		 */
	}
	
}
