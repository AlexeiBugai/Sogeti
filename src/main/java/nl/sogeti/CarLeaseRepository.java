package nl.sogeti;

import java.util.ArrayList;
import java.util.List;

import nl.sogeti.dto.Car;
import nl.sogeti.dto.Customer;

/**
* Create data in memory. Contains lists of customers and cars. 
* Provide methods to work with data. 
*/

public class CarLeaseRepository {

	private List<Customer> customers = new ArrayList<Customer>();
	private List<Car> cars = new ArrayList<Car>();
	
	public CarLeaseRepository() {

		customers.add(new Customer("John Smith", "Blekekijlaan", "3E", "3447GR", "Utrecht", "aaa1@test.com", "+31619899900"));
		customers.add(new Customer("Frank Smith", "Blekekijlaan", "4E", "3447GR", "Utrecht", "aaa2@test.com", "+31619899901"));
		customers.add(new Customer("Alex Smith", "Blekekijlaan", "5E", "3447GR", "Utrecht", "aaa3@test.com", "+31619899902"));

		cars.add(new Car("BMW", "X5", "1", 4, 100, 70000, 63000));
		cars.add(new Car("BMW", "X1", "1", 4, 100, 13000, 10000));
		cars.add(new Car("BMW", "X3", "1", 4, 100, 16000, 12000));
		
	}

	public Customer getCustomerFromRepository(int id) {
		return customers.get(id);
	}

	public void deleteCustomerFromRepository(int id) {
		customers.remove(id);
	}

	public void addCustomerToRepository(Customer customer) {
		customers.add(customer);
	}

	public void modifyCustomerFromRepository(int id, Customer customer) {
		customers.set(id, customer);
	}

	public Car getCarFromRepository(int id) {
		return cars.get(id);
	}

	public void deleteCarFromRepository(int id) {
		cars.remove(id);
	}

	public void addCarToRepository(Car car) {
		cars.add(car);		
	}

	public void modifyCarFromRepository(int id, Car car) {
		cars.set(id, car);
	}
	
}
