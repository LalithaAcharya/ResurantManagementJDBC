package service;
import java.util.ArrayList;
import java.util.List;
import java.lang.NullPointerException;
import java.sql.SQLException;

import dao.AdminDao;
import dao.GetConnection;
import dao.userDao;
import model.Food;
import model.user;
import utility.FoodNotFoundException;

import utility.OrdersNotFoundException;

public class userImplement implements userService{
	private userDao Dao = new userDao();
	
	public void addFood(user u) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		Dao.addFood(u);
	}
	public List<user> showAllOrders() throws OrdersNotFoundException,FoodNotFoundException, ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		return Dao.showAllOrders();
	}
	
}
