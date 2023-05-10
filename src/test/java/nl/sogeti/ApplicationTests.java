package nl.sogeti;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import nl.sogeti.dto.Car;
import nl.sogeti.dto.Customer;
import nl.sogeti.services.CarController;
import nl.sogeti.services.CustomerController;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
class ApplicationTests {
	
	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
	    ResponseEntity<Customer> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/get-customer-by-id?id=0", Customer.class);
	    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
		ResponseEntity<Customer> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.mgt + "/actuator", Customer.class);
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	  }

	@Test
	public void shouldReturnFalse() 
	{
		assertFalse(
			this.testRestTemplate
				.getForObject("http://localhost:" + port + "/get-customer-by-id?id=0", Customer.class)
				.getName().isEmpty());
	}

	@Test
	public void testCustomerController() {
		CustomerController customerController = new CustomerController();

		//Test for getCustomerById
		Customer customer = customerController.getCustomerById(0);
		assertNotNull(customer);
		assertEquals(customer.getName(), "John Smith");
		
		//Test for deleteCustomer
		customerController.deleteCustomer(0);

		Customer customer2 = customerController.getCustomerById(0);
		assertNotNull(customer2);
		assertEquals(customer2.getName(), "Frank Smith");
		
		//Test for modifyCustomerById		
		customer2.setName("Test name");
		customerController.modifyCustomerById(0, customer2);
		
		Customer customer3 = customerController.getCustomerById(0);
		assertNotNull(customer3);
		assertEquals(customer3.getName(), "Test name");
		
		//Test for addCustomer		
		customer2.setName("New name");
		customerController.addCustomer(customer2);;
		
		Customer customer4 = customerController.getCustomerById(2);
		assertNotNull(customer4);
		assertEquals(customer4.getName(), "New name");
	}
	
	@Test
	public void testCarController() {
		CarController carController = new CarController();

		//Test for getCarById
		Car car = carController.getCarById(0);
		assertNotNull(car);
		assertEquals(car.getModel(), "X5");
		
		//Test for deleteCustomer
		carController.deleteCar(0);

		Car car2 = carController.getCarById(0);
		assertNotNull(car2);
		assertEquals(car2.getModel(), "X1");
		
		//Test for modifyCustomerById		
		car2.setModel("Test model");
		carController.modifyCarById(0, car2);
		
		Car car3 = carController.getCarById(0);
		assertNotNull(car3);
		assertEquals(car3.getModel(), "Test model");
		
		//Test for addCustomer		
		car2.setModel("New model");
		carController.addCar(car2);;
		
		Car car4 = carController.getCarById(2);
		assertNotNull(car4);
		assertEquals(car4.getModel(), "New model");
	}
		
}
