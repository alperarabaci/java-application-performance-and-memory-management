package main;

public class Main {

	public static void main(String[] args) {
		// 40. The String Pool
		String one = "hello";
		String two = "hello";

		System.out.println(one.equals(two));
		System.out.println(one == two);
		System.out.println("---------------");

		Integer i = 76;
		String three = i.toString();
		String four = "76";

		System.out.println(three.equals(four));
		// this return false:
		/**
		 * now this line of code three equals four produced a false it's possible at
		 * some point in the future that line of code could result in a true because of
		 * this internal optimization that the virtual machine can do. It hasn't done it
		 * yet in this instance but it could do it in the future to say ah I've got two
		 * strings here that have the same underlying value I can remove one of them and
		 * safely point both able references to the same single object on the heap
		 */
		System.out.println(three == four);
		System.out.println("---------------");

		// 41. Interning Strings
		Integer j = 76;
		/**
		 * https://stackoverflow.com/questions/10578984/what-is-java-string-interning
		 * Basically doing String.intern() on a series of strings will ensure that all
		 * strings having same contents share same memory. So if you have list of names
		 * where 'john' appears 1000 times, by interning you ensure only one 'john' is
		 * actually allocated memory.
		 */
		String five = j.toString().intern();
		String six = "76";

		System.out.println(five.equals(six));
		System.out.println(five == six);
	}

}
