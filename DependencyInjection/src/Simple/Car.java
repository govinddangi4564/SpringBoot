package Simple;

interface Engine{
	public void engineStart();
}

class PetrolEngine implements Engine{
	public void engineStart(){
		System.out.println("Petrol Engine started");
	}
}

class ElectricEngine implements Engine{
	@Override
	public void engineStart() {
			System.out.println("Electric Engine started.");
	}
}

class DiselEngine implements Engine{
	@Override
	public void engineStart() {
			System.out.println("Disel Engine started.");
	}
}

public class Car {
	Engine en;
	public Car(Engine en) {
		this.en = en;
	}
	public void startCar() {
		en.engineStart();
		System.out.println("Car is Started..");
	}
}


