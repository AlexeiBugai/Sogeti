package nl.sogeti.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* Car DTO to collect data about cars 
*/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

	private String make;
	private String model;
	private String version;
	private int doors;
	private double co2Emission;
	private double grossPrice;
	private double nettPrice;
	
	public Car() {
	}
	
	public Car(String make, String model, String version, int doors, double co2Emission, double grossPrice, double nettPrice) {
		this.make = make;
		this.model = model;
		this.version = version;
		this.doors = doors;
		this.co2Emission = co2Emission;
		this.grossPrice = grossPrice;
		this.nettPrice = nettPrice;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getVersion() {
		return version;
	}

	public int getDoors() {
		return doors;
	}

	public double getCo2Emission() {
		return co2Emission;
	}

	public double getGrossPrice() {
		return grossPrice;
	}

	public double getNettPrice() {
		return nettPrice;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public void setCo2Emission(double co2Emission) {
		this.co2Emission = co2Emission;
	}

	public void setGrossPrice(double grossPrice) {
		this.grossPrice = grossPrice;
	}

	public void setNettPrice(double nettPrice) {
		this.nettPrice = nettPrice;
	}
  
}