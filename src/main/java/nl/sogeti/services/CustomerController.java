package nl.sogeti.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.sogeti.CarLeaseRepository;
import nl.sogeti.dto.Customer;

/**
* Controller for web services to work with customer 
*/

@Controller
public class CustomerController {

	CarLeaseRepository carLeaseRepository = new CarLeaseRepository();
	
	@GetMapping("/get-customer-by-id")
	@ResponseBody
	public Customer getCustomerById(@RequestParam(value = "id") int id) {
		return carLeaseRepository.getCustomerFromRepository(id);
	}

	@PostMapping(value = "/add-customer", consumes = "application/json")
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		carLeaseRepository.addCustomerToRepository(customer);
	}
  
	@PutMapping(value = "/modify-customer-by-id", consumes = "application/json")
	@ResponseBody
	public void modifyCustomerById(@RequestParam(value = "id") int id, @RequestBody Customer customer) {
	  	carLeaseRepository.modifyCustomerFromRepository(id, customer);
	}
  
	@DeleteMapping("/delete-customer-by-id")
	@ResponseBody
	public void deleteCustomer(@RequestParam(value = "id") int id) {
		carLeaseRepository.deleteCustomerFromRepository(id);
	}
  
}