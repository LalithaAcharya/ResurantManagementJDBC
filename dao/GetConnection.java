package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.FoodNotFoundException;
import utility.OrdersNotFoundException;
//import utility.OrdersNotFoundException;
import model.Food;
import model.user;

public abstract class GetConnection {
	 abstract public Connection getDbConnection() throws ClassNotFoundException, SQLException;

	public abstract void addFood(Food f) throws ClassNotFoundException;

	public void updateFood(int option, int Id, String newFood) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public void deleteFood(int Id) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	public Food findFood(Food f) throws ClassNotFoundException, FoodNotFoundException{
		// TODO Auto-generated method stub
		return null;
	}

	public List<Food> showAllFood() throws FoodNotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFood(user u) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	public List<user> showAllOrders() throws ClassNotFoundException, OrdersNotFoundException{
		// TODO Auto-generated method stub
		return null;
	}
	 
}
/*public interface AdminOperation {
	public abstract void addFood(Food f);
	
	public abstract void deleteFood(int Id);
	
	public abstract void updateFood(Food f);
	
	public abstract Food findFood(Food f) throws FoodNotFoundException;
	
	public List<Food> showAllEmployees();
	
}*/