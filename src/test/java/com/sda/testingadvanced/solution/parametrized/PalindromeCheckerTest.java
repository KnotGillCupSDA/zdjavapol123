package com.sda.testingadvanced.solution.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromeCheckerTest {

	@ParameterizedTest
	@CsvSource(value = { "kok, true", "sok, false" })
	void shouldTestIfStringIsPalindrome(String text, boolean expected) {
	}
}
