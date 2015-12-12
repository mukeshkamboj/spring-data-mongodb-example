package unit_test.com.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import unit_test.SpringConfigurationUT;

import com.persistence.entity.User;
import com.persistence.repository.UserRepository;
import com.service.impl.UserServiceImpl;

public class UserServiceImplUT extends SpringConfigurationUT {

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Before
	public void initialize() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void save() {
		User user = new User();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userService.save(user);
	}

	@Test
	public void getUser() {
		String userName = "userName";
		User user = new User("ABC", "XYZ", "userName");
		Mockito.when(userRepository.findByUserName(userName)).thenReturn(
				Arrays.asList(user));
		Assert.assertArrayEquals(new User[] { user },
				new User[] { userService.getUser(userName) });
		Mockito.when(userRepository.findByUserName(userName)).thenReturn(null);
		Assert.assertNull(userService.getUser(userName));
		Mockito.when(userRepository.findByUserName(userName)).thenReturn(
				new ArrayList<User>());
		Assert.assertNull(userService.getUser(userName));
	}

}