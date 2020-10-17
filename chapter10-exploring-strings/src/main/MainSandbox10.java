package main;

public class MainSandbox10 {

	/**
	 * Run vith vm argument -XX:+PrintStringTableStatistics
	 * @param args
	 */
	public static void main(String[] args) {
		//Empty main:
		/**
		 *  StringTable statistics:
			Number of buckets       :     65536 =    524288 bytes, each 8
			Number of entries       :      2393 =     38288 bytes, each 16
			Number of literals      :      2393 =    167408 bytes, avg  69.957
			Total footprsize_t         :           =    729984 bytes
			Average bucket size     :     0.037
			Variance of bucket size :     0.036
			Std. dev. of bucket size:     0.191
			Maximum bucket size     :         2
			
		 */

		//String user1Name = "alper";
		//String user1LastName = "arabaci";

		//String user2Name = "ugur";
		//String user2LastName = "arabaci";
		
		//Strings:
		/**
		 * We know why "lastname"s are count only once. (check chapter 9)
		 * StringTable statistics:
			Number of buckets       :     65536 =    524288 bytes, each 8
			Number of entries       :      2396 =     38336 bytes, each 16
			Number of literals      :      2396 =    167552 bytes, avg  69.930
			Total footprsize_t         :           =    730176 bytes
			Average bucket size     :     0.037
			Variance of bucket size :     0.036
			Std. dev. of bucket size:     0.191
			Maximum bucket size     :         2
		 */
		
		
		//User user1 = new User("alper", "arabaci");
		//User user2 = new User("ugur", "arabaci");
		//
		/**
			StringTable statistics:
			Number of buckets       :     65536 =    524288 bytes, each 8
			Number of entries       :      2397 =     38352 bytes, each 16
			Number of literals      :      2397 =    167608 bytes, avg  69.924
			Total footprsize_t         :           =    730248 bytes
			Average bucket size     :     0.037
			Variance of bucket size :     0.036
			Std. dev. of bucket size:     0.191
			Maximum bucket size     :         2
		*/
		
		//User2 user1 = new User2("alper", "arabaci");
		//User2 user2 = new User2("ugur", "arabaci");
		
		//User2 user1 = new User2("alper", "arabaci".intern());
		//User2 user2 = new User2("ugur", "arabaci".intern());
		
		//In User2 I used intern. But nothing changed:		
		/**
		 * 
			Number of buckets       :     65536 =    524288 bytes, each 8
			Number of entries       :      2397 =     38352 bytes, each 16
			Number of literals      :      2397 =    167608 bytes, avg  69.924
			Total footprsize_t         :           =    730248 bytes
			Average bucket size     :     0.037
			Variance of bucket size :     0.036
			Std. dev. of bucket size:     0.191
			Maximum bucket size     :         2
		 */
	}
}
