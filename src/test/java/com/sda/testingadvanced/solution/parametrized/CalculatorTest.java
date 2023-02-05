package com.sda.testingadvanced.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sda.testingadvanced.parametrized.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeEach
	void setUp() {
		System.out.println("setUp");
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearDown");
	}

	@Test
	void shouldAddTwoPositiveNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");

		//when
		double sum = calculator.add(3.0, 5.0);

		//then
		assertEquals(8.0, sum, "3 + 5 should be 8");
	}

	@Test
	void shouldAddTwoNegativeNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");

		//when
		double sum = calculator.add(-2.0, -1.0);

		//then
		assertEquals(-3.0, sum, "-2 + -1 should be -3");
	}

	@Test
	void shouldAddPositiveAndNegativeNumber() {
		//when
		double sum = calculator.add(-2.0, 1.0);

		//then
		assertEquals(-1.0, sum, "-2 + 1 should be -1");
	}

	@ParameterizedTest
	@ValueSource(doubles = {-1, -1.0, 0.0, 0, 1.0, 1, 6.666, 1023313104})
	void shouldAddZero(double number) {
		//when
		double sum = calculator.add(number, 0.0);

		//then
		assertEquals(number, sum, number + " + 0 should be " + number);
	}
}
