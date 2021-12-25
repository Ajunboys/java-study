package com.codedok.java8.tutorial.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example2_Lambda {

	public static void main(String[] args) {
		
		// lambda
		Runnable runnable = () -> System.out.println("Hello World");
		ActionListener actionListener = event -> System.out.println("button clicked");
	    Runnable multiStatement = () -> {
	    	System.out.print("Hello");
	    	System.out.println(" World");
	    };
		
	    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;
	    BinaryOperator<Long> add = (x, y) -> x + y;
	    
		Comparator<String> comparator = (first, second) -> first.length() - second.length();

		List<String> names = Arrays.asList("Ajunboys", "jack", "Jason", "TonyWei");
		Collections.sort(names, comparator);
		System.out.println("names sorted by length(reversed)  >>");
		System.out.println(names);
		System.out.println();

		sendEmail(new Runnable() {
			@Override
			public void run() {
				System.out.println("send。。。");
			};
		});
		
		sendEmail(() -> {
			System.out.println("send....");
		});
		
		Predicate<String> predicate = new Predicate<String>() {
			public boolean test(String t) {
				return t.startsWith("OO");
			};
		};
		
		Predicate<String> predicateStr = t -> t.startsWith("File:");
		
		Consumer<String> consumer = new Consumer<String>() {
			public void accept(String t) {
				System.out.println("text:" + t);
			};
		};
		
		Consumer<String> consumerStr = message -> System.out.println("message:" + message);
	
	
		Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
	}
	
	private static void sendEmail(Runnable runnable) {
		System.out.println("send mail...");
		runnable.run();
		System.out.println("send finished...");
	}

}
