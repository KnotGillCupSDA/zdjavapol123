package com.sda.testingadvanced.solution.parametrized.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.sda.testingadvanced.parametrized.fibonacci.FibonacciIterative;
import com.sda.testingadvanced.parametrized.fibonacci.FibonacciRecursive;
import com.sda.testingadvanced.parametrized.fibonacci.FibonacciSequence;

public class FibonacciSequenceTest {

	@Test
	void shouldCalculate3rdFibonacciSequenceElement() {
		int nth = 3;
		FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();

		BigInteger fibonacciNumber = fibonacciRecursive.getFibonacciNumber(nth);

		assertEquals(BigInteger.TWO, fibonacciNumber);
	}

	@ParameterizedTest
	@MethodSource("fibonacciData")
	void shouldCalculateNthFibonacciSequenceElement(FibonacciSequence fibonacciRecursive,
			int nth,
			BigInteger expected) {
		assertEquals(expected, fibonacciRecursive.getFibonacciNumber(nth));
	}

	public static Stream<Arguments> fibonacciData() {
		FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
		FibonacciIterative fibonacciIterative = new FibonacciIterative();
		return Stream.of(
				Arguments.of(fibonacciRecursive, 3, BigInteger.TWO),
				Arguments.of(fibonacciRecursive, 5, BigInteger.valueOf(5)),
				Arguments.of(fibonacciRecursive, 19, BigInteger.valueOf(4181)),
				Arguments.of(fibonacciRecursive, 44, BigInteger.valueOf(701408733)),
				Arguments.of(fibonacciIterative, 3, BigInteger.TWO),
				Arguments.of(fibonacciIterative, 5, BigInteger.valueOf(5)),
				Arguments.of(fibonacciIterative, 19, BigInteger.valueOf(4181)),
				Arguments.of(fibonacciIterative, 44, BigInteger.valueOf(701408733))
		);
	}
}
