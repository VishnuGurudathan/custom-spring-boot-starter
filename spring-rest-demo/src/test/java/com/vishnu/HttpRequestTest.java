/**
 * spring-rest-demo : com.vishnu
 */
package com.vishnu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * Test class to have a sanity check, by asserting the behavior of the application.
 *
 * @author : vishnu.g
 * created on : 02/Sep/2020
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	
	private final TestRestTemplate restTemplate;
	
	public HttpRequestTest(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api",
				String.class)).contains("Hello world !!!");
	}
}
