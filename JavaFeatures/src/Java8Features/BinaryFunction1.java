package Java8Features;

import java.util.function.BiFunction;

public class BinaryFunction1 {
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> bif = (a,b) -> (a+b);
		
		System.out.println(bif.apply(10, 20));
	}
}
