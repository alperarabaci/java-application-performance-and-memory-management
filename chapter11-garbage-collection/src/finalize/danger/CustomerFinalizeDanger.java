package finalize.danger;

public class CustomerFinalizeDanger {

	private String name;

	public CustomerFinalizeDanger(String name) {
		this.setName(name);
	}

	public CustomerFinalizeDanger(CustomerFinalizeDanger customer) {
		this.name = customer.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * App stopped suddenly without wait this method!
	 * So don't trust finalize!
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("This object is being g.c. " + name);
		while(true);
	}
}
