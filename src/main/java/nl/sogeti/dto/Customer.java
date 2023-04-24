package nl.sogeti.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* Customer DTO to collect data about customers 
*/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	private String name;
	private String street;
	private String houseNumber;
	private String zipCode;
	private String place;
	private String email;
	private String phoneNumber;
  
	public Customer() {
	}
	
	public Customer(String name, String street, String houseNumber, String zipCode, String place, String email, String phoneNumber) {
		this.name = name;
		this.street = street;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.place = place;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getPlace() {
		return place;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
  
}