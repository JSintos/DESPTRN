package jandjsandwiches.com.ph.model;

public interface Item {
	String getName();
	void setName(String name);
	String getDescription();
	void setDescription(String description);
	String getPrice();
	void setPrice(String price);
	String getIngredients();
	void setIngredients(String ingredients);
	String getCalorieCount();
	void setCalorieCount(String calorieCount);
	String getImageName();
	void setImageName(String imageName);
}
