package jandjsandwiches.com.ph.model.sandwich;

public class BagelToast implements Sandwich {
private String name, description, price, ingredients, calorieCount, imageName;
	
	public BagelToast() {
		name = "Bagel toast";
		description = "Pressed, toasted bagel filled with vegetables and cheese and grilled on a sandwich toaster or panini press.";
		price = "250";
		ingredients = "Toasted bagel, vegetables, and cheese.";
		calorieCount = "100";
		imageName = "bageltoast.jpg";
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
