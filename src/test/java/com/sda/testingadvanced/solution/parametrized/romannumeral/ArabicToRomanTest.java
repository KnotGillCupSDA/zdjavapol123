package com.sda.testingadvanced.solution.parametrized.romannumeral;

import static com.sda.testingadvanced.parametrized.romannumeral.RomanNumeralConverter.romanFor;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.sda.testingadvanced.parametrized.romannumeral.ArabicToRoman;

class ArabicToRomanTest {
	@Test
	void shouldConvert10ToX() {
		// given
		int a = 10;

		// when
		String number = romanFor(a);

		// then
		assertEquals("X", number);
	}

	@ParameterizedTest
	//@EnumSource(value = ArabicToRoman.class, names = {"THOUSAND", "FOUR_HUNDRED", "NINETY"})
	@EnumSource
	void shouldConvertSimpleArabicNumbers(ArabicToRoman arabicToRoman) {
		// when
		String number = romanFor(arabicToRoman.getArabic());

		// then
		assertEquals(arabicToRoman.getRoman(), number);
	}
}