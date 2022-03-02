package service;

import java.util.ArrayList;
import java.util.List;

import model.Food;
import utility.FoodNotFoundException;

public interface AdminService {

public abstract void addFood(Food f) throws ClassNotFoundException;
	
	public abstract void deleteFood(int Id) throws ClassNotFoundException;
	
	public abstract void updateFood(int option, int Id, String newFood) throws ClassNotFoundException;
	
	public abstract Food findFood(Food f) throws ClassNotFoundException, FoodNotFoundException;
	
	public List<Food> showAllFood() throws FoodNotFoundException, ClassNotFoundException;
	
}
