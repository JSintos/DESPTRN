package jandjsandwiches.com.ph.model;

public class Bacon implements Sandwich {
	private String name, description, price, ingredients, calorieCount, imageName;
	
	public Bacon() {
		name = "Bacon";
		description = "Often eaten with ketchup or brown sauce.";
		price = "Php 250";
		ingredients = "Bacon, buttered/ toasted bread, and ketchup or brown sauce.";
		calorieCount = "100";
		imageName = "bacon.jpg";
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Here! - " + name);
	}
}
