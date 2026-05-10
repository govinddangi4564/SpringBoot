package Java8Features;

import java.util.Arrays;
import java.util.function.Predicate;

public class Predicate1 {
	public static void main(String[] args) {
		
		Predicate<Integer> pr = (a) -> a > 10;
		System.out.println(pr.test(100));
		
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		Arrays.stream(arr).filter(a -> a % 2 == 0).forEach(a -> System.out.println(a));
	}
}
