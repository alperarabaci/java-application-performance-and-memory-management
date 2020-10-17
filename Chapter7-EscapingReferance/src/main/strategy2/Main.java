package main.strategy2;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		records.getCustomers().clear();

		for (Customer next : records.getCustomers().values()) {
			System.out.println(next);
		}

	}

}
