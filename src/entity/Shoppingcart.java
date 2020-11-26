package entity;

public class Shoppingcart {
	private String username;
	private String id;
	private String price;
	private String num;

	public Shoppingcart() {
		// TODO Auto-generated constructor stub
	}

	public Shoppingcart(String username, String id, String price, String num) {
		super();
		this.username = username;
		this.id = id;
		this.price = price;
		this.num = num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Shoppingcart [username=" + username + ", id=" + id + ", price=" + price + ", num=" + num + "]";
	}

}
