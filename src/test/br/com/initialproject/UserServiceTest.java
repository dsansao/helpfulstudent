package br.com.initialproject;

import br.com.initialproject.dto.UserDTO;
import br.com.initialproject.exception.ValidationException;
import br.com.initialproject.model.User;
import br.com.initialproject.model.enumeration.Gender;
import br.com.initialproject.model.enumeration.Role;
import br.com.initialproject.repository.UserRepository;
import br.com.initialproject.service.UserService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	private UserRepository userRepository;

	@Before
	public void setup() {

		userRepository = mock(UserRepository.class);
		User user = mock(User.class);
		when(userRepository.save(user)).thenReturn(null);
	}

	@Test(expected = ValidationException.class)
	public void createUserCpfInvalid() {
		UserDTO userDto = new UserDTO("diego", "diego.lockerz@gmail.com", "password1", "111111111", new Date(), "32", Gender.MALE, Role.ADMIN, true);
		userService.create(userDto);
	}

	@Test(expected = ValidationException.class)
	public void createUserWithoutUsername() {
		UserDTO userDto = new UserDTO(null, "diego.lockerz@gmail.com", "password1", "111111111", new Date(), "32", Gender.MALE, Role.ADMIN, true);
		userService.create(userDto);
	}
}
