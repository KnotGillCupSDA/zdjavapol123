package com.sda.testingadvanced.parametrized;

public class Calculator {

	private double lastResult;

	public double add(double a, double b) {
		this.lastResult = a + b;
		return lastResult;
	}

	public double divide(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Can't divide by 0");
		}
		return a / b;
	}

	public double getLastResult() {
		return lastResult;
	}
}
