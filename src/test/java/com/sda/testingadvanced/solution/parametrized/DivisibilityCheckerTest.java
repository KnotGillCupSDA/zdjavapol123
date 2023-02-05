package com.sda.testingadvanced.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.sda.testingadvanced.parametrized.DivisibilityChecker;

class DivisibilityCheckerTest {

	@ParameterizedTest(name = "run #{index} with [{arguments}]" )
	@ValueSource(ints = {-3, 0, 3, 9, 12})
	void shouldBeDivisibleBy3(Integer number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-2, 1, 4})
	@NullSource
	void shouldNotBeDivisibleBy3(Integer number) {
		assertFalse(DivisibilityChecker.isDivisibleBy3(number));
	}


	@ParameterizedTest
	@CsvSource(value = {"-2, false", "-3, true", "0, true", "1, false", "3, true"})
	void testDivisibilityBy3(Integer number, boolean expected) {

		/*
		What is happening in the background is something like this:
		String strNumber = "-2";
		Integer n = Integer.parseInt(strNumber);
		 */

		boolean result = DivisibilityChecker.isDivisibleBy3(number);
		assertEquals(expected, result);
	}

}