package main.strategy5;

public class Customer implements ReadonlyCustomer {
	private String name;

	public String getName() {
		return name;
	}

	public Customer(String name) {
		this.setName(name);
	}

	public Customer(Customer customer) {
		this.setName(customer.getName());
	}

	public String toString() {
		return getName();
	}

	public void setName(String name) {
		this.name = name;
	}

}
