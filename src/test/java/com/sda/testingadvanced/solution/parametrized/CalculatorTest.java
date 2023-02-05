package com.sda.testingadvanced.solution.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sda.testingadvanced.parametrized.Calculator;

public class CalculatorTest {

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
	}

	@AfterEach
	void tearDown() {
		System.out.println("tearDown");
	}

	@Test
	void shouldAddTwoPositiveNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");

		//given
		Calculator calculator = new Calculator();

		//when
		double sum = calculator.add(3.0, 5.0);

		//then
		assertEquals(9.0, sum, "3 + 5 should be 8");
	}

	@Test
	void shouldAddTwoNegativeNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");
	}
}
