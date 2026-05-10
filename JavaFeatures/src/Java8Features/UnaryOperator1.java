package Java8Features;

import java.util.function.UnaryOperator;

public class UnaryOperator1 {
	public static void main(String[] args) {
		
		UnaryOperator<Integer> square = x -> x * x;

        System.out.println(square.apply(5));
	}
}
