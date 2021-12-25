package com.codedok.java8.tutorial.ch03;

import java.util.List;
import java.util.stream.Collectors;

import com.codedok.java8.tutorial.domain.Task;
import com.codedok.java8.tutorial.domain.TaskType;
import com.codedok.java8.tutorial.utils.DataUtils;

public class Example1_Stream {
	
	public static void main(String[] args) {
		List<Task> tasks = DataUtils.getTasks();
		
		List<String> readingTasks = tasks.stream()
				.filter(t->t.getType() == TaskType.READING)
				.sorted((t1, t2)->t1.getTitle().length() - t2.getTitle().length())
				.map(Task::getTitle).collect(Collectors.toList());
		
		readingTasks.forEach(System.out::println);
		
		readingTasks.forEach(Example1_Stream::print);
		
	}
	
	private static void print(String title) {
		System.out.println("title:" + title);
	}
	
}
