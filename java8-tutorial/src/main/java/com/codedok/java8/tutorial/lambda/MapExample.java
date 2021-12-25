package com.codedok.java8.tutorial.lambda;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		for(Map.Entry<Integer, String> entry : map.entrySet()){
		    System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		
		map.forEach((key, value)->System.out.println("key:" + key + ", value:" + value));
	}
}
