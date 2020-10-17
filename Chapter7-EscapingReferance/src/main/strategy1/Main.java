package main.strategy1;

import java.util.Iterator;

public class Main {

public static void main(String[] args) {
	CustomerRecords records = new CustomerRecords();

	records.addCustomer(new Customer("John"));
	records.addCustomer(new Customer("Simon"));
	
	//bunu yaparsak, baskasinin class'ini biziklamis oluruz.
	//records.getCustomers().clear();
	
	/*
	for (Customer next : records.getCustomers().values()) {
		System.out.println(next);
	}
	*/
	
	print(records);
	
	Iterator<Customer> iterator = records.iterator();
	iterator.next();
	iterator.remove();
	
	print(records);

}

	private static void print(CustomerRecords records) {
		for (Customer customer : records) {
			System.out.println(customer);
		}
		System.out.println("-------");
	}
	
}
