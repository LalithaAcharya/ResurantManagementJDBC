package service;

import java.util.ArrayList;
import java.util.List;
import java.lang.NullPointerException;

import dao.AdminDao;
import dao.GetConnection;
import model.Food;
import utility.FoodNotFoundException;

public class AdminImplement implements AdminService{

	private AdminDao Dao = new AdminDao();

	@Override
	public void addFood(Food f) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Dao.addFood(f);
	}
	@Override
	public void deleteFood(int Id) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		Dao.deleteFood(Id);
	}

	@Override
	public void updateFood(int option, int Id, String newName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
			Dao.updateFood(option,Id,newName);
	}

	@Override
	public Food findFood(Food e) throws ClassNotFoundException, FoodNotFoundException{
		// TODO Auto-generated method stub
		return Dao.findFood(e);
	}

	@Override
	public List<Food> showAllFood() throws FoodNotFoundException, ClassNotFoundException{
		// TODO Auto-generated method stub
		return Dao.showAllFood();
	}
	
}
