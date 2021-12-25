package com.codedok.java8.tutorial.ch01;

public class App1 implements App1I {
	
	@Override
	public void doSth() {
		System.out.println("inside App1");
	}
	
	public static void main(String[] args) {
		new App1().doSth();
	}
}
interface App1I {
	default void doSth() {
		System.out.println("inside A");
	}
}
