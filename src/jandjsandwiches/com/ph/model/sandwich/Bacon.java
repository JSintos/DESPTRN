package jandjsandwiches.com.ph.model.sandwich;

public class Bacon extends Sandwich {
	public Bacon() {
		name = "Bacon";
		description = "Often eaten with ketchup or brown sauce.";
		price = "250";
		ingredients = "Bacon, buttered/ toasted bread, and ketchup or brown sauce.";
		calorieCount = "100";
		imageName = "bacon.jpg";
	}
	
	@Override
	public Sandwich clone() {
		return new Bacon();
	}
}
