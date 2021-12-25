package com.codedok.java8.tutorial.ch01;

public abstract class CalculatorFactory {
	public static Calculator getInstance() {
		return new BasicCalculator();
	}
}
