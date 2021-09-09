package jandjsandwiches.com.ph.model;

public class BakedBean implements Sandwich {
	private String name, description, price, ingredients, calorieCount;
	
	public BakedBean() {
		name = "Baked bean";
		description = "Canned baked beans on white or brown bread, sometimes with butter.";
		price = "Php 250";
		ingredients = "Baked beans, garnishes such as lettuces and toppings such as mayonnaise or ketchup.";
		calorieCount = "100";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCalorieCount() {
		return calorieCount;
	}

	public void setCalorieCount(String calorieCount) {
		this.calorieCount = calorieCount;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Here! - " + name);
	}
}
