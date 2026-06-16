package Simple;

public class CarMain {
	public static void main(String[] args) {
		Engine en = new DiselEngine();
		Car car = new Car(en);
		car.startCar();
	}
}
