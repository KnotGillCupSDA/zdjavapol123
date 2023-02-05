package com.sda.testingadvanced.solution.parametrized;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void shouldAddTwoNegativeNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");
	}

	@Test
	void shouldAddTwoPositiveNumbers() {
		System.out.println("shouldAddTwoPositiveNumbers");
	}
}
