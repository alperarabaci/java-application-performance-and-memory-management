package main;

public class User2 {

	private String firstName;
	private String lastName;

	public User2(String firstName, String lastName) {
		this.setFirstName(firstName.intern());
		this.setLastName(lastName.intern());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}