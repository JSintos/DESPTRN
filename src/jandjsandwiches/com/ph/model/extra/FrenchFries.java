package jandjsandwiches.com.ph.model.extra;

public class FrenchFries implements Extra {
	private String name, price, imageName;
	
	public FrenchFries() {
		name = "French fries";
		price = "25";
		imageName = "frenchfries.png";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
	
	@Override
	public Extra clone() {
		return new FrenchFries();
	}
}
