package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class ReduceAndCount {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int sum = Arrays.stream(arr).reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum);

		int prod = Arrays.stream(arr).reduce(1, (a, b) -> a * b);
		System.out.println("Product = " + prod);

		int max = Arrays.stream(arr).reduce((a, b) -> a > b ? a : b).getAsInt();
		System.out.println("Max = " + max);

		int min = Arrays.stream(arr).reduce((a, b) -> a < b ? a : b).getAsInt();
		System.out.println("Min = " + min);

		long count = Arrays.stream(arr).count();
		System.out.println("Count = " + count);

		List<Employee> list = List.of(
				new Employee(101, "raj", 29, 49000), 
				new Employee(102, "Abhi", 25, 78000),
				new Employee(103, "Goutam", 40, 63000), 
				new Employee(104, "Jay", 39, 50000),
				new Employee(105, "rajesh", 20, 41000));
		
		long count2 = list.stream().filter(a -> a.getSalary() > 40000 && a.getAge() > 30).count();
		
		System.out.println("Employee count = " + count2);
	}
}
