package Java8Features;

@FunctionalInterface
interface Enjoy{
	public void run();
}

public class functionalInterface {
	public static void main(String[] args) {
		Enjoy e = () -> {
			System.out.println("This is functional interface method");
		};
		
		e.run();
	}
}
