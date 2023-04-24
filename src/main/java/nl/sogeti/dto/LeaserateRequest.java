package nl.sogeti.dto;

/**
* Leaserate Request for JSON 
*/

public class LeaserateRequest {

	private final int customerId;
	private final int carId;
	private final int duration;
	private final double mileage;
	private final double interest;
  
	public LeaserateRequest(int customerId, int carId, int duration, double mileage, double interest) {
		this.customerId = customerId;
		this.carId = carId;
		this.duration = duration;
		this.mileage = mileage;
		this.interest = interest;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getCarId() {
		return carId;
	}

	public int getDuration() {
		return duration;
	}

	public double getMileage() {
		return mileage;
	}

	public double getInterest() {
		return interest;
	}
  
}