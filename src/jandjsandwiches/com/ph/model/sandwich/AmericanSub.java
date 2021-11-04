package jandjsandwiches.com.ph.model.sandwich;

public class AmericanSub extends Sandwich {
	public AmericanSub() {
		name = "American sub";
		description = "Traditionally uses sliced turkey breast, ham, roast beef, American or cheddar cheese, chopped or shredded lettuce, tomatoes and green peppers on a roll of bread.";
		price = "250";
		ingredients = "Meat, cheese, assorted vegetables, and condiments.";
		calorieCount = "100";
		imageName = "americansub.jpg";
	}
	
	@Override
	public Sandwich clone() {
		return new AmericanSub();
	}
}
