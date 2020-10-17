package main.strategy5;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		/**
		 * Find return a copy of John.
		 * So we can not replace Jane with orginal John.
		 */
		ReadonlyCustomer c = records.find("John");
		Customer customer = (Customer) c;
		customer.setName("Jane");
		
		for (Customer next : records.getCustomers().values()) {
			System.out.println(next);
		}

	}

}
