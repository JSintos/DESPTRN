package jandjsandwiches.com.ph.model.extra;

public class FrenchFries extends Extra {
	public FrenchFries() {
		name = "French fries";
		price = "25";
		imageName = "frenchfries.png";
	}
	
	@Override
	public Extra clone() {
		return new FrenchFries();
	}
}
