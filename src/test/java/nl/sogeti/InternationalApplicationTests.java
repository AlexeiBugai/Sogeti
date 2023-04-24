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

import nl.sogeti.dto.Customer;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
class InternationalApplicationTests {
	
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
	public void shouldReturnFalseForJoke() 
	{
		assertFalse(
			this.testRestTemplate
				.getForObject("http://localhost:" + port + "/get-customer-by-id?id=0", Customer.class)
				.getName().isEmpty());
	}
	
}
