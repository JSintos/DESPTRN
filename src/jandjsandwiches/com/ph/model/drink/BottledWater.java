package jandjsandwiches.com.ph.model.drink;

public class BottledWater implements Drink {
	private String name, price, imageName;
	
	public BottledWater() {
		name = "Bottled Water";
		price = "15";
		imageName = "bottledwater.png";
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
}
