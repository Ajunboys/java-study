package com.codedok.java8.tutorial.ch01;

public class BasicCalculator implements Calculator {

	public int add(int first, int second) {
		return first + second;
	}

	public int subtract(int first, int second) {
		return first - second;
	}

	public int divide(int number, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("divisor can't be zero.");
		}
		return number / divisor;
	}

	public int multiply(int first, int second) {
		return first * second;
	}

}
