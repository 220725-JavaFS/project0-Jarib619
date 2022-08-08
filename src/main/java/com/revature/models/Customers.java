package com.revature.models;

import java.util.Objects;

public class Customers {

	private int customerID;
	private String firstName;
	private String lastName;
	private String homeNumber;
	private String streetName;
	private String city;
	private String state;
	private int zipcode;
	private Accounts accountNumber;
	
	
	public Customers(int customerID, String firstName, String lastName, String homeNumber, String streetName,
			String city, String state, int zipcode, Accounts accountNumber) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.homeNumber = homeNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.accountNumber = accountNumber;
	}


	public Customers() {
		super();
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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


	public String getHomeNumber() {
		return homeNumber;
	}


	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	public Accounts getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Accounts accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, city, customerID, firstName, homeNumber, lastName, state, streetName,
				zipcode);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(city, other.city)
				&& customerID == other.customerID && Objects.equals(firstName, other.firstName)
				&& Objects.equals(homeNumber, other.homeNumber) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(state, other.state) && Objects.equals(streetName, other.streetName)
				&& zipcode == other.zipcode;
	}


	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", homeNumber=" + homeNumber + ", streetName=" + streetName + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + ", accountNumber=" + accountNumber + "]";
	}
	
	
	
	
	
	
}
