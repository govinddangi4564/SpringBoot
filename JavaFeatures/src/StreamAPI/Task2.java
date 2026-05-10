package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
	public static void main(String[] args) {
		int ar[] = {1,2,3,4,3,6,7,8,2,10,12,23,16,18,19};
		Arrays.stream(ar).distinct().forEach(a -> System.out.print(a + " "));
		System.out.println();
		List<Employee> list = List.of(
				new Employee(101, "raj", 29, 49000), 
				new Employee(102, "Abhi", 25, 78000),
				new Employee(103, "Goutam", 40, 63000), 
				new Employee(104, "Jay", 39, 50000),
				new Employee(105, "rajesh", 20, 41000));
		
		list.stream().forEach(a -> System.out.println(a));
		System.out.println();
		
		List<Employee> sen = list.stream().filter(a -> a.getAge() > 30).collect(Collectors.toList());
		sen.stream().forEach(a -> System.out.println(a));
		
		int newArr[] = Arrays.stream(ar).filter(a -> a % 3 == 0).toArray();
		System.out.println(Arrays.toString(newArr));
	}
}
