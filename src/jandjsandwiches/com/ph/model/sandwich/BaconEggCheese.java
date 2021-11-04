package jandjsandwiches.com.ph.model.sandwich;

public class BaconEggCheese extends Sandwich {
	public BaconEggCheese() {
		name = "Bacon, egg, and cheese";
		description = "Breakfast sandwich, usually with fried or scrambled egg.";
		price = "250";
		ingredients = "Bacon, eggs, cheese, and buttered/ toasted bread.";
		calorieCount = "100";
		imageName = "baconeggcheese.jpg";
	}
	
	@Override
	public Sandwich clone() {
		return new BaconEggCheese();
	}
}
