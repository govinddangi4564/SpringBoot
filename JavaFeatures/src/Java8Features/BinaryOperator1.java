package Java8Features;

import java.util.function.BinaryOperator;

public class BinaryOperator1 {
	public static void main(String[] args) {

		BinaryOperator<Integer> multiply = (a, b) -> a * b;

		System.out.println(multiply.apply(5, 4));
	}
}
