package integration_test.com.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import integration_test.com.SpringConfigurationIT;
import integration_test.com.util.IntegrationTestUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.persistence.repository.UserRepository;

public class UserControllerIT extends SpringConfigurationIT {

	@Autowired
	UserRepository userRepository;

	@Before
	public void setUp() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders
						.post("/user")
						.contentType(IntegrationTestUtil.APPLICATION_JSON_UTF8)
						.content(
								"{\"id\":\"2\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"userName\":\"userName1\"}"));
	}

	@Test
	public void getUserBasedOnUserName() throws Exception {
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/user/userName1")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(
						MockMvcResultMatchers
								.content()
								.string("{\"id\":\"2\",\"firstName\":\"firstName\",\"lastName\":\"lastName\",\"userName\":\"userName1\",\"primaryAddress\":null,\"addresses\":[]}"));
	}

	@After
	public void tearDown() {
		userRepository.delete("2");
	}
}
