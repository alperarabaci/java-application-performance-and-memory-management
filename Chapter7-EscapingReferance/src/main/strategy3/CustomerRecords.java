package main.strategy3;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
	
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<>();
	}
	
	public void addCustomer(Customer c) {
		this.records.put(c.getName(), c);
	}
		
	public Map<String, Customer> getCustomers() {
		//return Collections.unmodifiableMap(this.records);
		return Map.copyOf(this.records);
	}

}
