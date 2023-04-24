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
import nl.sogeti.dto.Car;

/**
* Controller for web services to work with car 
*/

@Controller
public class CarController {

	CarLeaseRepository carLeaseRepository = new CarLeaseRepository();
	
	@GetMapping("/get-car-by-id")
	@ResponseBody
	public Car getCarById(@RequestParam(value = "id") int id) {
		return carLeaseRepository.getCarFromRepository(id);
	}

	@PostMapping(value = "/add-car", consumes = "application/json")
	@ResponseBody
	public void addCar(@RequestBody Car car) {
		carLeaseRepository.addCarToRepository(car);
	}
  
	@PutMapping(value = "/modify-car-by-id", consumes = "application/json")
	@ResponseBody
	public void modifyCarById(@RequestParam(value = "id") int id, @RequestBody Car car) {
	  	carLeaseRepository.modifyCarFromRepository(id, car);
	}
  
	@DeleteMapping("/delete-car-by-id")
	@ResponseBody
	public void deleteCar(@RequestParam(value = "id") int id) {
		carLeaseRepository.deleteCarFromRepository(id);
	}
  
}