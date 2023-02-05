package com.sda.testingadvanced.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sda.testingadvanced.parametrized.DivisibilityChecker;

class DivisibilityCheckerTest {

	@ParameterizedTest
	@ValueSource(ints = {-3, 0, 3, 9, 12})
	void shouldBeDivisibleBy3(Integer number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-2, 1, 4})
	void shouldNotBeDivisibleBy3(Integer number) {
		assertFalse(DivisibilityChecker.isDivisibleBy3(number));
	}
}