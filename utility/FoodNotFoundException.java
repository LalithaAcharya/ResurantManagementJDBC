package utility;

public class FoodNotFoundException extends Exception{
	private int Id;
	public FoodNotFoundException(int Id) {
		this.Id = Id;
	}
	
	public String toString() {
		return "Food Not Found Exception" + this.Id;
	}
}
