package com.sda.testingadvanced.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.sda.testingadvanced.parametrized.PalindromeChecker;

public class PalindromeCheckerTest {

	@ParameterizedTest
	@CsvSource(value = { "ALA, true", "KAJAK, true", "Dupa, false", "Kajak, true",
			"34, false", "33, true", "aa, true", " ,false", "'',true"
	})
	@CsvFileSource(files = "src/test/resources/palindrome.csv")
	void shouldBePalindrome(String word, boolean expected) {
		boolean result = PalindromeChecker.isPalindrome(word);
		assertEquals(expected, result);
	}
}
