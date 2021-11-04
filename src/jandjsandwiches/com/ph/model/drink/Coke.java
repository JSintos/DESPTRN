package jandjsandwiches.com.ph.model.drink;

public class Coke extends Drink {
	public Coke() {
		name = "Coke";
		price = "50";
		imageName = "coke.png";
	}
	
	@Override
	public Drink clone() {
		return new Coke();
	}
}
