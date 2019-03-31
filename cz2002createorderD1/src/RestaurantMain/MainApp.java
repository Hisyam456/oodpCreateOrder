package RestaurantMain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import Class.Main;
import Class.*;

import Data.DataManager;

public class MainApp {

	public static void main(String[] args) {

		Main Restaurant = new Main();
		Scanner sc = new Scanner(System.in);
		
		int option = 0, itemPrice, itemTypeNum, itemID, i = 1, high, low;
		String itemName, itemDesc;
		Type itemType = Type.mains;
		
		while(option != 12){
			System.out.println("\nWhat would you like to perform:" 
					+ "\n(1) Create/Update/Remove menu item" 
					+ "\n(2) Create/Update/Remove promotion"
					+ "\n(3) Create new order" 
					+ "\n(4) View order" 
					+ "\n(5) Add/Remove order item/s to/from order" 
					+ "\n(6) Create reservation booking"
					+ "\n(7) Check/Cancel reservation booking"
					+ "\n(8) Check table availability" 
					+ "\n(9) Pay/Print bill invoice"
					+ "\n(10) Print sale revenue report by period (eg day or month) "
					+ "\n(11) Save data" 
					+ "\n(12) Exit");
			option = sc.nextInt();
			//System.out.print("Choice : ");
			//sc.nextLine();
			switch (option) {
				case 1: //Create
					Restaurant.printMenu();
					System.out.println("\nCreate/Update/Remove menu item:" 
							+ "\n(1) Create an Item"
							+ "\n(2) Update an Item" 
							+ "\n(3) Remove an Item"
							+ "\n(4) Back to Main Menu" 
							);
					System.out.print("Choice : ");
					option = sc.nextInt();
					switch (option) {
					case 1:
						//display
						Restaurant.printMenu();
						
						//user inputs and instruction
						System.out.print("\nPlease Enter Item Name: ");
						itemName = new String();
						itemName = sc.next();
	
						System.out.print("\nPlease Enter Item Price in SGD : ");
						itemPrice = sc.nextInt();
						
						System.out.println("\nPlease Enter Item Type");
						for (Type t : Type.values()) {
							System.out.println("(" + i + ")" + t.toString());
							i++;
						}
						System.out.print("Choice : ");
						itemTypeNum = sc.nextInt();
						
						System.out.print("\nPlease Enter Item Description : ");
						itemDesc = sc.next();
						
						System.out.print("\nGenerating Random ID...");
						Random r = new Random();
						low = 1000; // can be better
						high = 1999;
						itemID = r.nextInt(high-low) + low;
						System.out.println(itemID);
						
						//Create Object
						System.out.println("\nCreating a menu item...");
						ArrayList<AlaCarteItem> menuList = new ArrayList<AlaCarteItem>();
						//MenuItem newMenu = new MenuItem(itemName, itemPrice, itemID, itemDesc, <type data> ); //is it possible to put the type i want in?
						AlaCarteItem newMenu = new AlaCarteItem();  //(optional)
						
						//Set Object's attributes (Not necessary)
						newMenu.setMenuID(itemID); //random generated ID with no collision
						newMenu.setName(itemName);
						newMenu.setPrice(itemPrice);
						newMenu.setDesc(itemDesc);
						switch (itemTypeNum){
						case 1:
							newMenu.setCat(Type.mains);
							itemType = Type.mains;
							break;
						case 2:
							newMenu.setCat(Type.sides);
							itemType = Type.sides;
							break;
						case 3:
							newMenu.setCat(Type.desserts);
							itemType = Type.desserts;
							break;
						case 4:
							newMenu.setCat(Type.drinks);
							itemType = Type.mains;
							break;
						}
						
						//Set ArrayList and Write data
						menuList.add(new AlaCarteItem(itemName, itemPrice, itemID, itemDesc,itemType));
						DataManager.writeSerializedObject("MenuItems.db", menuList); //Write Data
						ArrayList<String> lol = new ArrayList<String>();
						lol.add("lol");
						lol.add("lol1");
						lol.add("lol2");
						lol.add("lol3");
						DataManager.writeSerializedObject("TEST.txt", lol); //Write Data
						
						
						//Print Data Saved
						System.out.println("New Menu Item Added!");
						for(AlaCarteItem menuitem : menuList) {
							System.out.println(
									  menuitem.getMenuID() + "      |     " 
									+ menuitem.getName()   + "      |     " 
									+ menuitem.getPrice()  + "      |     " 
									+ menuitem.getCat()    + "      |     " 
									+ menuitem.getDesc());
						}
						System.out.println("\nItem Successfully Added!");
						//should repeat? for multiple menu? or
						//exit to main menu
						break;
					case 2: //Update
						//Load Current MenuList
						//Prompt for which one to update -> CHOICE
						//Check if CHOICE exist -> re-prompt if does not exist
						//Update the changes
						//another update
						//exit to main menu
						break;
					case 3: //Remove
						//Load Current MenuList
						//Prompt for which one to update by ID
						//Check if ID exist -> re-prompt if does not exist
						//Remove Process
						//Another remove
						//exist to main menu
						break;
					case 4:
						break;
						//exit to main menu
					}
					break;
				case 2: 
					//Create Promotion 
					//All the choices
					break;
				case 3:
					//Moon
					Restaurant.createOrder();
					break;
				case 4:
					//Restaurant.printMenu();
					//Restaurant.printPromoItem();
					Restaurant.viewOrder();
					break;
				case 5:
					Restaurant.addRemoveOrder();
					break;
				case 6: 
					
				//Create reservation Booking 
				//Scan 
				//Restaurant.createResBooking(name, contactno, etc);
					
				case 7: 
				
				int hpno; 
				// Scan for contact no 
				// Ask if they want to check/remove 
				// Check -  Restaurant.checkRes(hpno)
				// Remove - Restaurant.removeRes(hpno)
				
				case 8:
					Restaurant.printAvailableTables();
					break;
				case 9:
					Restaurant.payPrintBill();
					break;
				case 10:
					Restaurant.printReport();
					
					break;
				case 11: 
					Restaurant.createwriteData();
					Restaurant.writePromoItems();
					//DataManager.readSerializedObject("MenuItem.db");
					break; 
			}
		}
		
	}

}
