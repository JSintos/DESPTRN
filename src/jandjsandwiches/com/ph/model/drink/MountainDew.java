package jandjsandwiches.com.ph.model.drink;

public class MountainDew implements Drink {
	private String name, price, imageName;
	
	public MountainDew() {
		name = "Mountain Dew";
		price = "50";
		imageName = "mountaindew.png";
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
