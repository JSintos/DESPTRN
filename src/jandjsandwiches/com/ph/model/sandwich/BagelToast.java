package jandjsandwiches.com.ph.model.sandwich;

public class BagelToast extends Sandwich {
	public BagelToast() {
		name = "Bagel toast";
		description = "Pressed, toasted bagel filled with vegetables and cheese and grilled on a sandwich toaster or panini press.";
		price = "250";
		ingredients = "Toasted bagel, vegetables, and cheese.";
		calorieCount = "100";
		imageName = "bageltoast.jpg";
	}
	
	@Override
	public Sandwich clone() {
		return new BagelToast();
	}
}
