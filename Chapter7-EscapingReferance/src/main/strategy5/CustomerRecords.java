package main.strategy5;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
		
	public Map<String, Customer> getCustomers() {
		return Map.copyOf(this.records);
	}
	
	public ReadonlyCustomer find(String name) {
		return new Customer(records.get(name));
	}
}
