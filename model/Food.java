package model;

public class Food {
	private int Id;
	private String Name;
	private double Price;
	
	public Food(int Id,String Name,double Price) {
		super();
		this.Id=Id;
		this.Name=Name;
		this.Price=Price;
	}
	
	public Food() {
		super();
	}
	public int getID() {
		return Id;
	}

	public void setID(int iD) {
		Id = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
	
}
