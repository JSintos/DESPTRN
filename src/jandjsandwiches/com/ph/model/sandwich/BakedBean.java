package jandjsandwiches.com.ph.model.sandwich;

public class BakedBean extends Sandwich {
	public BakedBean() {
		name = "Baked bean";
		description = "Canned baked beans on white or brown bread, sometimes with butter.";
		price = "250";
		ingredients = "Baked beans, garnishes such as lettuces and toppings such as mayonnaise or ketchup.";
		calorieCount = "100";
		imageName = "bakedbean.jpg";
	}
	
	@Override
	public Sandwich clone() {
		return new BakedBean();
	}
}
