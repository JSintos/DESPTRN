package jandjsandwiches.com.ph.model.drink;

import jandjsandwiches.com.ph.model.Item;

public abstract class Drink implements Item {
	public String name, price, imageName;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		return null;
	}
	
	@Override
	public void setDescription(String description) {
	}
	
	@Override
	public String getPrice() {
		return price;
	}
	
	@Override
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String getIngredients() {
		return null;
	}
	
	@Override
	public void setIngredients(String ingredients) {
	}

	@Override
	public String getCalorieCount() {
		return null;
	}
	
	@Override
	public void setCalorieCount(String calorieCount) {
	}
	
	@Override
	public String getImageName() {
		return imageName;
	}
	
	@Override
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public abstract Drink clone();
}
