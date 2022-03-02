package service;

import java.sql.SQLException;
import java.util.List;

import model.user;
import utility.FoodNotFoundException;
import utility.OrdersNotFoundException;

public interface userService {

	public abstract void addFood(user u) throws ClassNotFoundException,SQLException;
	
	public abstract List<user> showAllOrders() throws OrdersNotFoundException,FoodNotFoundException,SQLException, ClassNotFoundException;
}
