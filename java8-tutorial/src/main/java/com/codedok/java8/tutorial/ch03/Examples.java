package com.codedok.java8.tutorial.ch03;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import com.codedok.java8.tutorial.domain.Task;
import com.codedok.java8.tutorial.domain.TaskType;
import com.codedok.java8.tutorial.utils.DataUtils;

public class Examples {
	
	public static List<String> allReadingTasks(List<Task> tasks) {
		return tasks.stream().
				filter(t->t.getType() == TaskType.READING).
				sorted(comparing(Task::getCreatedOn)).
				map(Task::getTitle).
				collect(toList());
	}

    public static List<String> allReadingTasksSortedByCreatedOnDesc(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(comparing(Task::getCreatedOn).reversed()).
                map(Task::getTitle).
                collect(toList());

    }

    public static List<Task> allDistinctTasks(List<Task> tasks) {
        return tasks.stream().distinct().collect(toList());
    }

    public static List<String> topN(List<Task> tasks, int n) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                sorted(comparing(Task::getCreatedOn)).
                map(Task::getTitle).
                limit(n).
                collect(toList());
    }

    public static long countAllReadingTasks(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                count();
    }

    public static List<String> allDistinctTags(List<Task> tasks) {
        return tasks.stream().flatMap(task -> task.getTags().stream()).distinct().collect(toList());
    }

    public static boolean isAllReadingTasksWithTagBooks(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                allMatch(task -> task.getTags().contains("books"));
    }

    public static boolean isAnyReadingTasksWithTagJava8(List<Task> tasks) {
        return tasks.stream().
                filter(task -> task.getType() == TaskType.READING).
                anyMatch(task -> task.getTags().contains("java8"));
    }

    public static String joinAllTaskTitles(List<Task> tasks) {
        return tasks.stream().
                map(Task::getTitle).
                reduce((first, second) -> first + " *** " + second).
                get();
    }
	public static void main(String[] args) {
		List<Task> tasks = DataUtils.getTasks();
		
		tasks.forEach(t->{
			System.out.println("task:" + t.toString());
		});
		
		List<String> readingTasks = allReadingTasks(tasks);
		
		readingTasks.forEach(System.out::println);
	}

}
