package main;

public class Customer {

	private String name;

	public Customer(String name) {
		this.setName(name);
	}
	
	public Customer(Customer customer) {
		this.name = customer.name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
