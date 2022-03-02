package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


import model.Food;
import model.user;
import dao.GetConnection;
import dao.userDao;
import dao.AdminDao;
import service.AdminImplement;
import service.AdminService;
import service.userImplement;
import utility.ConnectionManager;
import utility.FoodNotFoundException;
import utility.OrdersNotFoundException;

//import utility.OrdersNotFoundException;
public class MainTest {

	public static void main(String[] args) throws FoodNotFoundException, ClassNotFoundException, SQLException, IOException {
		Scanner sc=new Scanner (System.in);
		System.out.println("***********************************************************************");

	   	System.out.println("---------------------------BYTE-TO RESTURANT--------------------------");
		System.out.println("                   Life's too short for boring food                   ");

		System.out.println("***********************************************************************");

		System.out.println("Every day is a good day for your resturant!");

		System.out.println("***********************************************************************");
		System.out.println("Welcome to your happy place byte-to resturant!!");
		System.out.println("***********************************************************************");

		System.out.println("Are you a user or Admin?");
		boolean temp=true;
		 while(temp) {
			System.out.println("1.Admin");
			System.out.println("2.User");

			int choice =sc.nextInt();
			AdminImplement as=new AdminImplement();
			userImplement us=new userImplement();
			userDao ud=new userDao();
			AdminDao ad=new AdminDao();

			if(choice==1) {
				System.out.println("Please enter choose you operation: ");
				System.out.println();
				boolean temp1=true;
				while(temp1) {
					System.out.println("======================Admin===========================");
					System.out.println("1.Add Food to Menu Card");
					System.out.println("2.Edit Food in Menu Card");
					System.out.println("3.Search Food in Menu Card");
					System.out.println("4.Delete Food fron Menu Card");
					System.out.println("5.Display Food item in Menu Card");
					System.out.println("6.Bill");
					System.out.println("7.Exit");
					System.out.println("=======================================================");
					System.out.println();
					int choice1=sc.nextInt();
					switch(choice1) {
					case 1 : 
						System.out.println("-------------------------------------------------");
						System.out.println("                   Add food                       ");
						System.out.println("--------------------------------------------------");
						int Id;
						sc.nextLine();
						String Name;
						double Price;
						System.out.println();
						System.out.println("Enter the number of food item you want to add:");
						int n=sc.nextInt();
						for(int i=0;i<n;i++) {
							System.out.println("------------------------------------------------");
							System.out.println("Enter the food ID");
							Id=sc.nextInt();
							System.out.println("-------------------------------------------------");
							sc.nextLine();
							System.out.println("Enter the name of the food");
							Name=sc.nextLine();
							System.out.println("--------------------------------------------------");
							sc.nextLine();
							System.out.println("Enter the Price of the food");
							Price=sc.nextDouble();
							System.out.println("--------------------------------------------------");
							as.addFood(new Food(Id,Name,Price));
						}

						List<Food> list=as.showAllFood();

						for(Food f: list) {
							System.out.println("=================================================================="+"\n"+ "Food ID: " + f.getID() + "     |    " + "Food Name: " + f.getName() + "     |    " + "Food price: " + f.getPrice() + "\n=============================================================");
						}
						//System.out.println("Food added successfully");
						break;
					case 2:
						System.out.println("-------------------------------------------------");
						System.out.println("              Edit the food item                 ");
						System.out.println("-------------------------------------------------");
						System.out.println();
						System.out.println("Please do enter the food Id that you want to edit ");
						int id=sc.nextInt();
						System.out.println("-------------------------------------------------");
						System.out.println("Select one option which you want to edit" );
						System.out.println("1.Name");
						System.out.println("2.Price");
						System.out.println("-------------------------------------------------");
						int option=sc.nextInt();

						switch(option) {
						case 1:{
							System.out.println("-------------------------------------------------");
							System.out.println("Enter the new food name which has an id as "+id);
							sc.nextLine();
							String newName = sc.nextLine();
							System.out.println("-------------------------------------------------");
							as.updateFood(option,id,newName);
							break;
						}
						case 2:{
							System.out.println("-------------------------------------------------");
							System.out.println("Enter the food's new price which has an id as "+id);
							sc.nextLine();
							String newPrice = sc.nextLine();
							System.out.println("-------------------------------------------------");
							as.updateFood(option,id,newPrice);
							break;
						}
						}
						System.out.println("*******************************************************");
						System.out.println("Food updated successfully");
						System.out.println("******************************************************");
						break;
					case 3:
						System.out.println("--------------------------------------------------------------");
						System.out.println("              Search for a perticular food item               ");
						System.out.println("---------------------------------------------------------------");
						System.out.println("Enter the food Id to search the details of that perticular food");
						int displayid=sc.nextInt();
						Food item=as.findFood(new Food(displayid,null,0));
						System.out.println("==========================================================================");
						System.out.println("Food ID: "+item.getID()+ "  |  " +"Food Name: "+item.getName()+"   |  "+"Food Price: "+item.getPrice());
						System.out.println("==========================================================================");
						break;
					case 4:
						System.out.println("-------------------------------------------------");
						System.out.println("              Delete the food item                 ");
						System.out.println("-------------------------------------------------");
						System.out.println();
						System.out.println("Enter Food Id to delete Food record permanently: ");
						int delId=sc.nextInt();
						System.out.println("-------------------------------------------------");
						boolean found=false;
						Food fooddelete=null;
						List<Food> elist2 = as.showAllFood();
						for(Food e:elist2) {
							if(e.getID()==delId) {
								fooddelete=e;
								found=true;
							}
						}
						if(!found) {
							System.out.println("=======================================================================================================");
							System.out.println("Food is not present");
							System.out.println("=======================================================================================================");

						}
						else {
							as.deleteFood(delId);
							System.out.println("*****************************************************************************************************");
							System.out.println("Food deleted successfully!!");
							System.out.println("*****************************************************************************************************");
						}
						//System.out.println("------------------------------------------------------------------------------------------------------");
						break;
					case 5:
						System.out.println("-------------------------------------------------");
						System.out.println("              All Food List : \n");
						System.out.println("-------------------------------------------------");
						System.out.println();
						List<Food> flist1 = as.showAllFood();
						for(Food f: flist1)
						{
							System.out.println("======================================================================"+"\n"+ "Food ID: " + f.getID() + " | " + "Food Name: " + f.getName() + " | " + "Food Price: " + f.getPrice());
						}
						System.out.println("==========================================================================");
						break;
					case 6:
						System.out.println("---------------------------Bill--------------------------");
						System.out.println("   Order Id    |    Amount       |");
						ud.bill();
						System.out.println("---------------------------------------------------------");
						break;
					case 7:
						System.out.println();
						temp1=false;
					}
				}
			}
			else if(choice==2) {
				//do{
				boolean t=true;
				while(t) {
				System.out.println("==========================================================================");
				System.out.println("                                  User                                    ");
				System.out.println("==========================================================================");
				System.out.println();
				System.out.println("1.Display the MenuCard");
				System.out.println("2.Erder the food");
				System.out.println("3.Exit");
				System.out.println("==========================================================================");
				int choice2=sc.nextInt();
				switch(choice2) {
				case 1:
					System.out.println("------------------ -------------------------------------------");
					System.out.println("               All Food List                                  ");
					System.out.println("---------------------------------------------------------------");
					List<Food> flist1 = as.showAllFood();
					for(Food f: flist1)
					{
						System.out.println("==================================================================================="+"\n"+ "Food ID: " + f.getID() + "  |  " + "Food Name: " + f.getName() + "  |  " + "Food Price: " + f.getPrice());
					}
					System.out.println("==================================================================================");
					break;
				case 2:
					System.out.println("------------------ -------------------------------------------");
					System.out.println("                      Order food                              ");
					System.out.println("--------------------------------------------------------------");
					int orderId;
					sc.nextLine();
					int noOfQuantity;
					int Id;
					System.out.println("Enter the number of food item you want to Order:");
					int n=sc.nextInt();
					System.out.println("------------------ -------------------------------------------");
					for(int i=0;i<n;i++) {
						System.out.println("Enter the Order ID");
						orderId=sc.nextInt();
						System.out.println("------------------ -------------------------------------------");
						//sc.nextLine();
						System.out.println("Enter the quantity of the food");
						noOfQuantity=sc.nextInt();
						System.out.println("------------------ -------------------------------------------");
						//sc.nextLine();
						System.out.println("Enter the ID of the food");
						Id=sc.nextInt();
						System.out.println("------------------ -------------------------------------------");
						us.addFood(new user(orderId,noOfQuantity,Id));
						//System.out.println(u.getPayment());
					}
					List<user> list;
					try {
						list = us.showAllOrders();
						for(user f: list) {
							System.out.println("==============================================================="+"\n"+ "Order ID: " +f.getOrderId()  + "  |  " + "Quantity: " + f.getNoOfQuantity() + "  |  " + "Food Id: " + f.getID() + "\n=====================================================================");
						}
					} catch (ClassNotFoundException | OrdersNotFoundException | FoodNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//System.out.println("Food added successfully");
				break;
				}
			}
		}
	}
}


