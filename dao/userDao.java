package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Food;
import model.user;
import utility.ConnectionManager;
import utility.FoodNotFoundException;
import utility.OrdersNotFoundException;

public class userDao extends GetConnection{
	

	Connection database=null;
	private PreparedStatement pst=null;
	private ResultSet rs=null;
	
	public static final String INSERT_USER="insert into Orders values(?,?,?)";
	public static final String DISPLAY_USER="select * from Orders";
	
	public static final String PAYMENT="select order_id,o.numberofquantity*m.Price as payment from Menu m inner join Orders o on m.Id=o.Id group by o.Id";
	
	@Override
	public Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Connection dbCon = ConnectionManager.getConnection();
		return dbCon;
	}
	
	@Override
	public void addFood(user u) throws ClassNotFoundException, SQLException {
		try {
			database= getDbConnection();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		int i=0;
		try {
			pst=database.prepareStatement(INSERT_USER);
				pst.setInt(1, u.getOrderId());
				pst.setInt(2, u.getNoOfQuantity());
				pst.setInt(3, u.getID());
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
		public List<user> showAllOrders() throws ClassNotFoundException, OrdersNotFoundException{
			// TODO Auto-generated method stub
			try {
				database = getDbConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			user selectAllTemp=null;
			List<user> ulist = new LinkedList<>();
			try {
				pst=database.prepareStatement(DISPLAY_USER);
				rs=pst.executeQuery();
				while(rs.next()) {
					selectAllTemp = new user(0, 0, 0);
					selectAllTemp.setOrderId(rs.getInt("order_Id"));
					selectAllTemp.setNoOfQuantity(rs.getInt("numberofquantity"));
					selectAllTemp.setID(rs.getInt("Id"));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return ulist;
		}

		@Override
		public void addFood(Food f) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			
		}
		public void bill() throws SQLException {
			try {
				database = getDbConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Statement statement = database.createStatement();
			ResultSet result = statement.executeQuery(PAYMENT);
			while (result.next()) {
				String Data="";
				for(int i=1;i<=2;i++) {
					Data += result.getString(i) + "              |";
					}
				System.out.println(Data);
			}
		}
	}
