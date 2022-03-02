package utility;

public class OrdersNotFoundException extends Exception {
	
	private int OrderId;
	public OrdersNotFoundException(int OrderId) {
		this.OrderId = OrderId;
	}
	
	public String toString() {
		return "Food Not Found Exception" + this.OrderId;
}
}