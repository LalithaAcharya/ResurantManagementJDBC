package dao;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Food;
import utility.ConnectionManager;
import utility.FoodNotFoundException;

public  class AdminDao extends GetConnection {

	
	Connection database=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	public static final String INSERT="insert into Menu values(?,?,?)";
	//UPDATE_COMMAND = "UPDATE employee SET empname=?, age=?, designation=?
	public static final String DELETE="Delete From Menu where Id=? ";
	public static final String SEARCH="select * from Menu where Id=?";
	public static final String DISPLAY="select * from Menu";
	
	@Override
	public Connection getDbConnection() throws ClassNotFoundException {
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
	
	@Override
	public void addFood(Food f) throws ClassNotFoundException {
		database= getDbConnection();
		int i=0;
		try {
			pst=database.prepareStatement(INSERT);
				pst.setInt(1, f.getID());
				pst.setString(2, f.getName());
				pst.setDouble(3, f.getPrice());
				int result = pst.executeUpdate();
				if(result >= 1) {
					System.out.println("Food added successfully");
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Adding Record failed");
			e.printStackTrace();
		}
		finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
	
		@Override
		public void updateFood(int option, int Id, String newFood) throws ClassNotFoundException {
			database = getDbConnection();
			String sql = null;
			if(option == 1) {
				sql = "update Menu set Name = ? where Id = ?";	
			}
			else if(option == 2) {
				sql = "update Menu set Price = ? where Id = ?";	
			}	
			
			try {
				PreparedStatement ps = database.prepareStatement(sql);
				ps.setString(1, newFood);
				ps.setInt(2, Id);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Update Operation Failed.");
				e.printStackTrace();
			}
			
		}
			
			@Override
			public void deleteFood(int Id) throws ClassNotFoundException {
				database = getDbConnection();
				int i=0;
				try {
					pst=database.prepareStatement(DELETE);
					pst.setInt(1, Id);
					i=pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Delete Operation Failed.");
					e.printStackTrace();
				}
				finally {
					try {
						pst.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(i>0) {
					System.out.println("SQL Message-----Record Deleted Succesfully");
				}
			}
			
			@Override
			
			public Food findFood(Food f) throws FoodNotFoundException{
				try {
					database = getDbConnection();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Food findTemp = null;
				try {
					pst=database.prepareStatement(SEARCH);
					pst.setInt(1, f.getID());
					rs=pst.executeQuery();
					if(!rs.next()) {
						throw new FoodNotFoundException(f.getID());
						
					}
					findTemp = new Food();
					findTemp.setName(rs.getString("name"));
					findTemp.setPrice(rs.getInt("Price"));
					findTemp.setID(f.getID());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						pst.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				return findTemp;
				
			}
			
			@Override
			public List<Food> showAllFood() throws ClassNotFoundException {
				database = getDbConnection();
				// TODO Auto-generated method stub
				Food selectAllTemp=null;
				List<Food> elist = new LinkedList<>();
				try {
					pst=database.prepareStatement(DISPLAY);
					rs=pst.executeQuery();
					
					while(rs.next()) {
						selectAllTemp = new Food();
						selectAllTemp.setID(rs.getInt("ID"));
						selectAllTemp.setName(rs.getString("Name"));
						selectAllTemp.setPrice(rs.getInt("Price"));
						elist.add(selectAllTemp);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return elist;
			}

			
			
			
		}