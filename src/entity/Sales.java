package entity;

public class Sales {
	private String id;
	private int nnn;

	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(String id, int nnn) {
		super();
		this.id = id;
		this.nnn = nnn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getnnn() {
		return nnn;
	}

	public void setnnn(int nnn) {
		this.nnn = nnn;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", nnn=" + nnn + "]";
	}

	public int addOne() {
		this.nnn += 1;
		return this.nnn;
	}

}
