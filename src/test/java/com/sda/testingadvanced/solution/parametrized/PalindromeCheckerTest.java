package com.sda.testingadvanced.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromeCheckerTest {

	@ParameterizedTest
	@CsvSource(value = { "" })
	void shouldTestIfStringIsPalindrome(String test, boolean expected) {
	}
}
