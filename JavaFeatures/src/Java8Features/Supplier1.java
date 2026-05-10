package Java8Features;

import java.util.function.Supplier;

/*
 * Takes no input and return something
 * 
 * */

public class Supplier1 {
	public static void main(String[] args) {
		
		Supplier<Double> sup = () -> Math.random();
		System.out.println(sup.get());
		
	}
}
