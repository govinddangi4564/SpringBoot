package Java8Features;

import java.util.function.Function;

public class Function1 {
	public static void main(String[] args) {
		
		
		Function<String, Integer> fn = (a) -> a.length();
		System.out.println(fn.apply("Hello"));
		
		Function<String, String> fn1 = (a) -> a.toUpperCase();
		System.out.println(fn1.apply("Hello"));
		
		
	}
}
