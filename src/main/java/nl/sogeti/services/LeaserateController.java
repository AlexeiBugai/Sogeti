package nl.sogeti.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import nl.sogeti.CarLeaseRepository;
import nl.sogeti.dto.Car;
import nl.sogeti.dto.Customer;
import nl.sogeti.dto.LeaserateRequest;
import nl.sogeti.dto.LeaserateResponse;

/**
* Controller for web service to calculate leaserate
*/

@Controller
public class LeaserateController {

	CarLeaseRepository carLeaseRepository = new CarLeaseRepository();
	
	@PostMapping(value = "/leaserate-calculation", consumes = "application/json")
	@ResponseBody
	public LeaserateResponse leaserateCalculation(@RequestBody LeaserateRequest leaserateRequest) {
		
	    String uriCustomer = "http://localhost:8080/get-customer-by-id?id=" + leaserateRequest.getCustomerId();
	    String uriCar = "http://localhost:8080/get-car-by-id?id=" + leaserateRequest.getCarId();

    	RestTemplate restTemplate = new RestTemplate();

    	Customer customer = restTemplate.getForObject(uriCustomer, Customer.class);
		Car car = restTemplate.getForObject(uriCar, Car.class);

		LeaserateResponse leaserateResponse = new LeaserateResponse();		
		
		leaserateResponse.setName(customer.getName());
		leaserateResponse.setEmail(customer.getEmail());
		leaserateResponse.setPhoneNumber(customer.getPhoneNumber());
		
		leaserateResponse.setMake(car.getMake());
		leaserateResponse.setModel(car.getModel());
		leaserateResponse.setNettPrice(car.getNettPrice());
		
		leaserateResponse.setDuration(leaserateRequest.getDuration());
		leaserateResponse.setMileage(leaserateRequest.getMileage());
		leaserateResponse.setInterest(leaserateRequest.getInterest());
		
		double Leaserate = (((leaserateRequest.getMileage() / 12) * leaserateRequest.getDuration()) / car.getNettPrice()) + (((leaserateRequest.getInterest() / 100) * car.getNettPrice()) / 12);
		leaserateResponse.setLeaserate(Leaserate);
		
		return leaserateResponse;
	}
  
}