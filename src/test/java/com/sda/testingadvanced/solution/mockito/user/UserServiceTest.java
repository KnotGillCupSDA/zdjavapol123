package com.sda.testingadvanced.solution.mockito.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sda.testingadvanced.mockito.user.User;
import com.sda.testingadvanced.mockito.user.UserRepository;
import com.sda.testingadvanced.mockito.user.UserService;
import com.sda.testingadvanced.mockito.user.UserValidator;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	private static final User TOMASZ_WOZNIAK = new User(7L, "Tomasz", "Wozniak");
	@Mock
	private UserRepository userRepository;
	@Mock
	private UserValidator userValidator;
	@InjectMocks
	private UserService userService;

	@Test
	void shouldFindUserById() {
		//given
		//when anyone calls userRepository.findById(7L) then return tomaszWozniak
		when(userRepository.findById(7L)).thenReturn(Optional.of(TOMASZ_WOZNIAK));

		//when
		User actualUser = userService.getUserById(7L);

		//then
		assertEquals(TOMASZ_WOZNIAK, actualUser);
		verify(userRepository, times(1)).findById(7L);

	}

	@Test
	void shouldThrowExceptionWhenNoUserWithGivenId() {
		assertThrows(RuntimeException.class, () -> userService.getUserById(1L));
	}

	@Test
	void shouldAddValidUser() {
		//given
		when(userValidator.isUserValid(any())).thenReturn(true);

		//when
		userService.addUser(TOMASZ_WOZNIAK);

		//then
		//let's verify that valid user is passed to the proper repository method
		//userRepository.addUser should have been called once with TOMASZ_WOZNIAK parameter value
		verify(userRepository, times(1)).addUser(TOMASZ_WOZNIAK);
	}

	@Test
	void shouldNotAddInvalidUser() {
		//given
		when(userValidator.isUserValid(any())).thenReturn(false);

		//when
		//then
		assertThrows(RuntimeException.class, () -> userService.addUser(TOMASZ_WOZNIAK));
		//userRepository.addUser should NOT have been called at all
		verify(userRepository, never()).addUser(any());

	}
}
