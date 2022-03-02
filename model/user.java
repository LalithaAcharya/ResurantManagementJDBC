package model;

//import utility.OrdersNotFoundException;
import model.Food;
public class user {
public int OrderId;
public int noOfQuantity;
public int ID;
//public double Payment;

public user(int orderId,int noOfQuantity,int ID){
	super();
	this.OrderId=orderId;
	this.noOfQuantity=noOfQuantity;
	this.ID=ID;
	//this.Payment=Payment;
}
/*Food f=new Food();
public double getPayment() {
	return f.getPrice();
}

public void setPayment(double Payment,int Id) {
	
	Payment = f.getPrice();
}*/


public int getOrderId() {
	return OrderId;
}

public void setOrderId( int OrderId) {
	this.OrderId = OrderId;
}

public int getNoOfQuantity() {
	return noOfQuantity;
}

public void setNoOfQuantity(int noOfQuantity) {
	this.noOfQuantity = noOfQuantity;
}

public int getID() {
	return ID;
}

public void setID(int iD) {
	ID = iD;
}

public double setPayment(String payment2) {
	// TODO Auto-generated method stub
	return 0;
}


}

