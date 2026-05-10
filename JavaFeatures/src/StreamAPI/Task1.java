package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class Task1 {
	public static void main(String[] args) {
		int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		Arrays.stream(ar).filter(a -> a % 2 == 0).filter(a -> a > 5).forEach(a -> System.out.print(a + " "));

		System.out.println();
		System.out.println();

		List<Employee> list = List.of(new Employee(101, "raj", 29, 49000), new Employee(102, "Abhi", 25, 78000),
				new Employee(103, "Goutam", 40, 63000), new Employee(104, "Jay", 39, 50000),
				new Employee(105, "rajesh", 20, 41000));

		list.stream().filter(a -> a.getAge() > 30).forEach(a -> System.out.println(a));

		System.out.println();

		list.stream().filter(a -> a.getName().startsWith("A")).forEach(a -> System.out.println(a));

		// add the 2 years of every employee age
		list.stream().map(a -> {
			a.setAge(a.getAge() + 2);
			return a;
		}).forEach(a -> System.out.println(a));
		
		System.out.println();

		// convert all the employee name into capital letters..

		list.stream().map(a -> {
			a.setName(a.getName().toUpperCase());
			return a;
		}).forEach(a -> System.out.println(a));

		System.out.println();

		// sort the data based on age

		list.stream().sorted((a, b) -> a.getAge() - b.getAge()).forEach(a -> System.out.println(a));

		System.out.println();

		list.stream().sorted((a, b) -> b.getAge() - a.getAge()).forEach(a -> System.out.println(a));
		System.out.println();

		// sort the data based on Name

		list.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(a -> System.out.println(a));
	}
}
