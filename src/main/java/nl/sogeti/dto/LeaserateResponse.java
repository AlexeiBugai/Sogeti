package nl.sogeti.dto;

/**
* Leaserate Response for JSON 
*/

public class LeaserateResponse {

	private String name;
	private String email;
	private String phoneNumber;
	private String make;
	private String model;
	private int duration;
	private double mileage;
	private double interest;
	private double nettPrice;
	private double leaserate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getNettPrice() {
		return nettPrice;
	}
	public void setNettPrice(double nettPrice) {
		this.nettPrice = nettPrice;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getLeaserate() {
		return leaserate;
	}
	public void setLeaserate(double leaserate) {
		this.leaserate = leaserate;
	}
	
}