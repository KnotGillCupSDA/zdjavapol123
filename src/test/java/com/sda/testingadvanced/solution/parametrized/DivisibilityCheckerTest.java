package com.sda.testingadvanced.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerTest {

	@ParameterizedTest
	@ValueSource
	void shouldBeDivisibleBy3(Integer number) {
		//assertTrue(result);
	}
}