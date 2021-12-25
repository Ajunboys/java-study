package com.codedok.java8.tutorial.ch03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.codedok.java8.tutorial.domain.Task;
import com.codedok.java8.tutorial.domain.TaskType;
import com.codedok.java8.tutorial.utils.DataUtils;

public class Example1_Java7 {
	public static void main(String[] args) {
		List<Task> tasks = DataUtils.getTasks();
		List<Task> readingTasks = new ArrayList<>();
		
		for (Task task : tasks) {
			if (task.getType().equals(TaskType.READING)) {
				readingTasks.add(task);
			}
		}
		
		Collections.sort(readingTasks, new Comparator<Task>() {
			public int compare(Task t1, Task t2) {
				return t1.getTitle().length() - t2.getTitle().length();
			};
		});
		
		for (Task readingTask : readingTasks) {
			System.out.println(readingTask.getTitle());
		}
	}

}
