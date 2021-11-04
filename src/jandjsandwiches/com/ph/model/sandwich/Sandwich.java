package jandjsandwiches.com.ph.model.sandwich;

import jandjsandwiches.com.ph.model.Item;

public abstract class Sandwich implements Item {
	public String name, description, price, ingredients, calorieCount, imageName;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getPrice() {
		return price;
	}
	
	@Override
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
	public String getImageName() {
		return imageName;
	}
	
	@Override
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public abstract Sandwich clone();
}
