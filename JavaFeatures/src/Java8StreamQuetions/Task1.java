package Java8StreamQuetions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import StreamAPI.Employee;

public class Task1 {

	public static void main(String[] args) {

		List<Employee> list = List.of(new Employee(101, "raj", 29, 49000), new Employee(102, "Abhi", 25, 78000),
				new Employee(103, "Goutam", 40, 63000), new Employee(104, "Jay", 39, 50000),
				new Employee(105, "rajesh", 20, 41000));

// 1. Convert a List<String> to uppercase using streams

		List<String> list2 = Arrays.asList("Abhi", "Gopal", "Govind", "Jay");

		list2.stream().map(a -> a.toUpperCase()).forEach(a -> System.out.println(a));

// 2. From a list of integers, filter only even numbers.

		List<Integer> list3 = Arrays.asList(1, 2, 2, 4, 22, 13, 4, 55, 16, 7, 81, 9, 7, 10);

		list3.stream().filter(a -> a % 2 == 0).forEach(a -> System.out.print(a + " "));
		System.out.println();

// 3. Find the sum of all numbers in a list using streams.

		int sum = list3.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum);

// 4. Find the maximum number in a list using streams.

		int max = list3.stream().reduce((a, b) -> a > b ? a : b).get();
		System.out.println("Max = " + max);

// 5. Count how many numbers are greater than 10 in a list.

		list3.stream().filter(a -> a > 10).forEach(a -> System.out.print(a + " "));

// 6. Remove duplicate elements form a list using stream.

		list3.stream().distinct().forEach(a -> System.out.print(a + " "));

// 7. Convert a list of strings into a single comma-separated string.

		System.out.println();

// 8. Given a list of employees ,get all employees names.

		list.stream().map(a -> a.getName()).forEach(a -> System.out.print(a + " "));
		System.out.println();
// 9. From a list of employees, filter employees with salary > 50000.

		list.stream().filter(a -> a.getSalary() > 50000).forEach(a -> System.out.println(a));

// 10. Find the average salary of employees.

		double SalSum = list.stream().map(a -> a.getSalary()).reduce(0.0, (a, b) -> a + b);
		double avg = SalSum / list.size();
		System.out.println("Average salary = " + avg);

		double avgSalary = list.stream().mapToDouble(a -> a.getSalary()).average().getAsDouble();
		System.out.println("Average salary = " + avgSalary);

// 11. Sort a list of integers in descending order using streams.

// 12. Find the first element greater than 20.

// 13. Convert List<List<Integer>> into a single list using flatMap.

		List<List<Integer>> list4 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9));
		List<Integer> singleList = list4.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
		System.out.println(singleList);
	}

// 14. Group employee by department
// 15. Count employees in each department
// 16. Convert List<Employee> into Map<id, name>
// 17. Find the second highest number in a list.
// 18. Find duplicate elements in a list.
// 19. Find the most frequent element in a list.
// 20. Partition numbers into even and odd groups.
// 21. Find the top 3 highest salaries.
// 22. Merge two lists and remove duplicates.
// 23. Check if all numbers are positive.
// 24. Check if any numbers is divisible by 5.
// 25. Converts list to Map<Department, List<Employee>>.

}
