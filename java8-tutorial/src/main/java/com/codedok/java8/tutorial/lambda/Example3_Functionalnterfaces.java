package com.codedok.java8.tutorial.lambda;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example3_Functionalnterfaces {
	
	public static void main(String[] args) {
		
		Predicate<String> p = n -> n.startsWith("file:");
		
		Consumer<String> consumer = message -> 
		System.out.println("send message:" + message);
		
		Function<String, Integer> textLength = text -> text.length();
	
		Supplier<String> uuidSupplier = () -> UUID.randomUUID().toString();
		
	}

}
