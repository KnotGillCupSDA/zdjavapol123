package com.sda.testingadvanced.parametrized;

public class Calculator {

	private double lastResult;

	public double add(double a, double b) {
		this.lastResult = a + b;
		return lastResult;
	}

}
