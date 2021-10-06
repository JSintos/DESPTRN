package jandjsandwiches.com.ph.model.drink;

public class Coke implements Drink {
	private String name, price, imageName;
	
	public Coke() {
		name = "Coke";
		price = "50";
		imageName = "coke.png";
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
	public Drink clone() {
		return new Coke();
	}
}
