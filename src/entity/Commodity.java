package entity;

public class Commodity {
	private String id;
	private String price;
	private String name;
	private String type;
	private String brand;
	private String image;

	public Commodity(String id, String price, String name, String type, String brand, String image) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", price=" + price + ", name=" + name + ", type=" + type + ", brand=" + brand
				+ ", image=" + image + "]";
	}

	public Commodity() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getbrand() {
		return brand;
	}

	public void setbrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
