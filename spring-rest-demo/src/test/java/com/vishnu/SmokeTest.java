/**
 * spring-rest-demo : com.vishnu
 */
package com.vishnu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vishnu.controllers.ApiController;

/**
 * Simple smoke test class to check the context is creating the controller.
 *
 * @author : vishnu.g
 * created on : 02/Sep/2020
 */
@SpringBootTest
public class SmokeTest {

	@Autowired
	private ApiController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
