package Java8Features;

import java.util.function.Consumer;

/*
 * Takes 1 input and return nothing
 * 
 * */

public class Consumer1 {
	public static void main(String[] args) {

		Consumer<Integer> c = a -> System.out.println(a + 1);
		c.accept(5);

	}
}
