package com.herokuapp.s3_test_streams;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

public class Test {
	void testFilteredStrings() {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filteredStrings = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		System.out.println("filteredStrings: " + filteredStrings);

		System.out.println("Count of empty strings: " +
				strings.stream().filter(s -> s.isEmpty()).count());

		String mergedString = filteredStrings.stream().collect(Collectors.joining(", "));
		System.out.println("String merged with joining: " + mergedString);
	}

	void testInts() {
		Random random = new Random();
		random.ints().limit(9).sorted().forEach(System.out::println);
	}

	void testMap() {
		List<Integer> ints = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squares = ints.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.println("Distinct int squares: " + squares);
	}

	void testStats() {
		List<Integer> ints = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		IntSummaryStatistics stats = ints.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Ints: " + ints.stream().map(x -> "" + x).collect(Collectors.joining(", ")));
		System.out.println("Highest: " + stats.getMax());
		System.out.println("Lowest : " + stats.getMin());
		System.out.println("Sum    : " + stats.getSum());
		System.out.println("Average: " + stats.getAverage());
	}

	public void test() {
		testFilteredStrings();
		testInts();
		testMap();
		testStats();
	}
}