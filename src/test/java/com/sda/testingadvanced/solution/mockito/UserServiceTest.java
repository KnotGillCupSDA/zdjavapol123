package com.sda.testingadvanced.solution.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sda.testingadvanced.mockito.user.User;
import com.sda.testingadvanced.mockito.user.UserRepository;
import com.sda.testingadvanced.mockito.user.UserService;
import com.sda.testingadvanced.mockito.user.UserValidator;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserValidator userValidator;

	@InjectMocks
	private UserService userService;

	@Test
	void shouldFindUserById() {
		//given
		User tomaszWozniak = new User(7L, "Tomasz", "Wozniak");
		//when anyone calls userRepository.findById(7L) then return tomaszWozniak
		when(userRepository.findById(7L)).thenReturn(Optional.of(tomaszWozniak));

		//when
		User actualUser = userService.getUserById(7L);

		//then
		assertEquals(tomaszWozniak, actualUser);
		verify(userRepository, times(1)).findById(7L);

	}
}
