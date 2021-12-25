package com.codedok.java8.tutorial.ch01;

public class App2 implements App2IB, App2ID {
	public static void main(String[] args) {
		new App2().doSth();
	}
}

interface App2IA {
	default void doSth() {
		System.out.println("inside App2IA");
	}
}

interface App2IB {
	default void doSth() {
		System.out.println("inside App2IB");
	}
}

interface App2ID extends App2IB {
	default void doSth() {
		System.out.println("inside App2ID");
	}
}
