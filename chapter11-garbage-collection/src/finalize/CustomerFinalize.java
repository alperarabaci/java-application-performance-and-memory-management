package finalize;

public class CustomerFinalize {

	private String name;

	public CustomerFinalize(String name) {
		this.setName(name);
	}

	public CustomerFinalize(CustomerFinalize customer) {
		this.name = customer.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * In fact if we look now at the finalized method documentation in the Java
	 * eleven version of the Java docs will see the deprecation warning here is
	 * telling us that there are all sorts of damage we could do by using the
	 * finalized method.
	 */
	@Override
	protected void finalize() throws Throwable {
		System.out.println("This object is being g.c. " + name);
	}
}
