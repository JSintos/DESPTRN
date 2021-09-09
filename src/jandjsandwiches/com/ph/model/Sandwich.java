package jandjsandwiches.com.ph.model;

public interface Sandwich {
	String getName();
	String getDescription();
	String getPrice();
	String getIngredients();
	String getCalorieCount();
	void printDetails();
}
