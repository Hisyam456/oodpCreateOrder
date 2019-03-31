package Class;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.Random;


import Data.DataManager;
import java.io.*;

public class Main {
	ArrayList<Staff> staffList;
	ArrayList<Table> tableList; //Contain 30 Objects of Tables - Each object has attributes in table.java
	ArrayList<Reservation> resList; 
	ArrayList<Ordering> orderList = new ArrayList<Ordering>(); 
	ArrayList<AlaCarteItem> menuList = new ArrayList<AlaCarteItem>();
	ArrayList<Promotion> promoList = new ArrayList<Promotion>();
	Scanner sc = new Scanner(System.in);
	
	public Main(){
		getStaffList();
		getReservationList();
		getTableList();
		menuList= (ArrayList) DataManager.readSerializedObject("MenuItems.db");
		promoList= (ArrayList) DataManager.readSerializedObject("PromoItem.db");


	}
	
	//Moon
	public void printBigMenu()
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		   System.out.printf("%-15s %-28s %-60s %-15s %-3s", "ITEM ID", "ITEM NAME", "ITEM DESCRIPTION", "ITEM CATEGORY", "ITEM PRICE");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    
		    if(menuList == null || menuList.isEmpty()){
		    	System.out.println("No Menu Item");
		    }
		    
		    for(AlaCarteItem student: menuList){
		        System.out.format("%-15d %-28s %-60s %-15s %-3f", student.getMenuID(),student.getName(), student.getDesc(), student.getCat(), student.getPrice());
		        System.out.println();
		    }
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	//Moon
	public void printBigPromoItem()
	{
		
		promoList = new ArrayList<Promotion>();
		promoList= (ArrayList) DataManager.readSerializedObject("PromoItem.db");
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		   System.out.printf("%-15s %-28s %-60s %-15s %-3s", "PROMO ID", "PROMO NAME", "PROMO DESCRIPTION", "PROMO CATEGORY", "PROMO PRICE");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	    
	    for(Promotion p : promoList) {
	    	System.out.println(p.getName());
	    	for(AlaCarteItem pm: p.getMenuItem()){
		        System.out.format("%-15d %-28s %-60s %-15s %-3f",
		                pm.getMenuID(),pm.getName(), pm.getDesc(), pm.getCat(), pm.getPrice());
		        System.out.println();
		    }
	    	
	    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	    }
	}
	
	private void getStaffList(){
		staffList = new ArrayList<Staff>();
		staffList = (ArrayList) DataManager.readSerializedObject("Staff.db");
		System.out.println("        Staff Name     |    Gender    |    Staff ID       |    Role\n "+staffList);
	}
	
	
	private void getReservationList(){
		
	}
	private void getTableList(){
		tableList = new ArrayList<Table>();
		tableList = (ArrayList) DataManager.readSerializedObject("Table.db");
		Timestamp curDate = getcurrentDate();
//		if(resList!=null){
//			for(Reservation r:resList){
//				if(	r.getDateTime().getMonth()==curDate.getMonth() &&
//					r.getDateTime().getYear()==curDate.getYear() &&
//					r.getDateTime().getDay()==curDate.getDay()){
//					Table t =tableList.get(r.getTableID);
//					t.setStatus("Reserved");
//					t.setContactNo(r.getcontactNo);
//				}
//			}
//		}
	}
	public Timestamp getcurrentDate(){
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}
	
	public void printAvailableTables() {
		System.out.println("    Table Number |       Status       | Seat Capacity\n"+getAvailableTables());
	}
	
	
	public ArrayList<Table> getAvailableTables(){
		ArrayList<Table> AvailtableList = new ArrayList<Table>();
		for(Table t:tableList){
			if(t.getStatus().equals("Unoccupied")){
				AvailtableList.add(t);
			}
		}
		return AvailtableList;
	}
	
	public void printAvailableTablesPax(int no) {
		System.out.println("    Table Number |       Status       | Seat Capacity\n"+getAvailableTablesPax(no));
	}
	
	// Moon
	// Made extra changes
	public ArrayList<Table> getAvailableTablesPax(int px){
		ArrayList<Table> AvailtableList = new ArrayList<Table>();
		for(Table t:tableList){
			if(t.getStatus().equals("Unoccupied") && t.getPax() == px){
					AvailtableList.add(t);			
			}
		}
		return AvailtableList;
	}
	
	// Creating a whole new function for the selection of Menu
	// Moon
	// return the Ordering obj 
	public Ordering menuSelection(Ordering o)
	{
		Scanner sc = new Scanner(System.in);
		MainMenu ml = new MainMenu();
		

		ArrayList<AlaCarteItem> m = new ArrayList<AlaCarteItem>(); 
		ArrayList<Promotion> p = new ArrayList<Promotion>();
		ml.setMenuitem(menuList);	
		ml.setPromoitem(promoList);
		
		int ch = 0;
		
		do {
			System.out.println();
			System.out.println("1. Menu Items");
			System.out.println("2. Promotional Items");
			System.out.println("3. Done");
			System.out.println("4. Exit");	// Not working
			System.out.print("Choice: ");
			ch = sc.nextInt();
			
			int id;
			if(ch == 1)
			{
				// FInd the function to print the Menu Item
				ml.printListMenuItem();
				System.out.print("Item Id: ");
				id = sc.nextInt();
				m.add(menuList.get(id-1));
			}
			else if( ch == 2)
			{
				// Find the function to print the Promo Item
				ml.printpromoItem();
				System.out.print("Item Id: ");
				id = sc.nextInt();
				p.add(promoList.get(id-1));
			}
			else if(ch == 3) // Confirmation
			{
				
				Random rand = new Random();
				int r = (1 + rand.nextInt(5)) * 10000 + rand.nextInt(10000); // Need to Check that orderId did not exist in array (Have yet to implement)
				double cost = 0;
				
				o.setOrderID(r);
				o.setMenuList(ml);
				o.setStatus("UNPAID");
				o.setDate(getcurrentDate());
				o.setEmployeeID(o.getEmployeeID());
				o.setOrderID(o.getOrderID());
				
				ml.setMenuitem(m);
				ml.setPromoitem(p);
				
				if(!(o.getMenuList().getMenuitem().isEmpty()))
				{
					for(AlaCarteItem al : ml.getMenuitem())
					{
						cost += al.getPrice();
					}
				}
				if(!(o.getMenuList().getPromoitem().isEmpty()))
				{
					for(Promotion pm : o.getMenuList().getPromoitem())
					{
						cost += pm.getPrice();
					}
				}
				
				o.setTotalPrice(cost);
				o.printOrderInput();
				
				return o;
				
			}
			else if(ch == 4)
			{
				break;
			}
			else // Inputting the wrong input
			{
				System.out.println("Please re-enter your choice:");
				System.out.println();
			}
		} while(ch < 3 || ch > 0);
		
		return o;
	}
	
	// Moon
	public void createOrder()
	{
		Scanner scn = new Scanner(System.in);
		System.out.print("Staff ID: ");
		int staff = customScanner.checkId(scn);
		
		System.out.println("1. Reserved Table");
		System.out.println("2. New Customer");
		System.out.println("3. Back");
		int n = sc.nextInt();
		// n can only be 1,2,3
		
		int ind = 0;
		int indConf = 0;
		Ordering order = new Ordering();
		
		if(n == 1)
		{
			System.out.print("Contact Number: ");
			int contact = sc.nextInt();
			// Retrieve tableID from the reservation database
			// Assign table id to particular order
			
		}
		else if(n == 2)
		{
			
			System.out.print("How many pax?");
			int px = customScanner.readOnlyIntegers(scn);
			// try to make it read only a certain number
			// and get confirmation from customeScanner
			
			if(px == 1 || px == 2)
			{
				px = 2;
			}
			else if(px == 3 || px == 4)
			{
				px = 4;
			}
			else if(px >= 5 || px <= 8)
			{
				px = 8;
			}
			else if(px == 9 || px == 10)
			{
				px = 10;
			}
			

			ArrayList<Table> avail = new ArrayList<Table>();
			avail = getAvailableTablesPax(px);
		
			if(avail.isEmpty() == false)
			{
				System.out.println("There are seats available!");
				printAvailableTablesPax(px);
				System.out.print("Table Number: ");
				
				
				
				do
				{
					int ifExist = 0;
					ind = scn.nextInt();
					for(int i = 0; i < avail.size(); i++)
					{
						if(avail.get(i).getTableID() == ind && avail.get(i).getStatus().equals("Unoccupied"))
						{
							System.out.println("Table ID Accepted: " + avail.get(i).getTableID());
							indConf++;
							ifExist++;
							System.out.println();
						}
					}
					
					if(ifExist == 0)
					{
						System.out.println("Seat is already occupied!");
						System.out.print("Find another table (Y/N)?");
						char anTbl = scn.next().charAt(0);
						switch(anTbl)
						{
						case 'Y':
							System.out.print("Table Number: ");
							//ind = scn.nextInt();
							break;
						case 'N':
							// If  no. exit to main Menu
							indConf = 2;
							break;
						}
					}
					
							
					//	}
						
					
				}while(indConf == 0);	
			}
			else // if the avail table is empy
			{
				System.out.println("No Available tables left!");
				indConf = 2;
			}
		
		}
		else
		{
			return;
		}
		

		if(indConf == 2)
		{
			return;
		}
		else
		{
			order.setTableID(ind);
			order.setEmployeeID(staff);
			order = menuSelection(order);
			// return the new order made
		}
		
		System.out.print("Confirm order (Y/N): ");
		char conf = scn.next().charAt(0);
		if(conf == 'Y')
		{
			orderList.add(order);
			System.out.println("Order Confirmed!");
			for(Table t : tableList)
			{
				if(t.getTableID() == ind)
				{
					t.setStatus("Occupied");
				}
			}
			DataManager.writeSerializedObject("Table.db", tableList);
			staff = 0; // Depends
			return;
		}
		else
		{
			return;
		}
		
	
	}
		
		
	public void addRemoveOrder() 
	{
		int ind=0; 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Table ID: ");
		int tableID = sc.nextInt();
		
		
		Ordering currOrder = new Ordering();
		//Clone Order as a new order object 
		Ordering cloneOrder = new Ordering(); 
		int i = -1;
		for(Ordering or : orderList)
		{
			i++;
			if(or.getTableID() == (tableID-1))
			{
				ind = i; 
				// Try creating a clone here
				cloneOrder = or.cloning(currOrder);
				currOrder.printOrderInput();
			}
		}
		
		// Start the menu
		System.out.println();
		System.out.println("1. Add Item");
		System.out.println("2. Remove Item");
		System.out.println("3. Remove Whole Order");
		System.out.println("4. Back");
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:
			
			cloneOrder = menuSelection(cloneOrder);
			//Scanning to confirm updated changes 
			System.out.print("Confirm the updated order? ");
			//Confirm order update
			System.out.print("Confirm update to Order (Y/N): ");
			char conf = sc.next().charAt(0);
			if(conf == 'Y')
			{
				//Update the order object to the array list 
				orderList.set(ind, cloneOrder);
				return;
			}
			else
			{
				return;
			}
			
			
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		
		}
	}
	
	
	public void printMenu()
	{
		menuList = new ArrayList<AlaCarteItem>();
		menuList= (ArrayList) DataManager.readSerializedObject("MenuItems.db");
	
		System.out.println("   ItemID     |     Item Name      |    Item Price (SGD)   |  Type  |  Description\n"+menuList);
	
	}
	
	public void viewOrder()
	{
		ArrayList<Ordering> im = new ArrayList<Ordering>(); 
		
		//Creating arraylist of menu items (Alacarte)
		ArrayList<AlaCarteItem> d1 = new ArrayList<AlaCarteItem>();
		//d1.add(new MenuItem( "New York Burger", 20.00 , 1, "Best New York Burger with 22 ounces of ground beef", Type.mains));
		//d1.add(new MenuItem( "Singapore Burger", 25.00 , 2, "The best nasi lemak burger you will ever taste", Type.mains));
		
		//Creating an arraylist of menuitems tied to promo package
		ArrayList<AlaCarteItem> mi = new ArrayList<AlaCarteItem>();
		mi.add(menuList.get(0));
		mi.add(menuList.get(1));
		
		//Creating a new arraylist of promo items
		ArrayList<Promotion> p1 = new ArrayList<Promotion>(); 
		p1.add((new Promotion(mi, "Promo 1", 35.50, 1, "This is a test desc")));
		
		//Craeting a new menuList 
		MainMenu d2 = new MainMenu();
		d2.setMenuitem(d1);
		d2.setPromoitem(p1);
		
		im.add(new Ordering(1,1,1, d2 , "Unpaid", getcurrentDate(), 155.20));
		
		int tableID; 
		
		Scanner vo = new Scanner(System.in);
		System.out.print("\nPlease Enter Table Number to view order: ");
		//tableID = vo.nextInt();
		
		tableID = customScanner.readOnlyIntegers(vo);
		if(tableID==-1){
			return;
		}
		for(Ordering o:im){			
			if(o.getTableID()==tableID)
			{
				
				o.getMenuList().printListMenuItem();
				o.getMenuList().printpromoItem();
			}
		}
		//System.out.print("\nBack");
		
	}
	
	public void printOrderDetails(int tableID)
	{
		
	}
	
	public void writePromoItems()
	{
		ArrayList<AlaCarteItem> mi = new ArrayList<AlaCarteItem>();
		mi.add(menuList.get(0));
		mi.add(menuList.get(1));
		
		ArrayList<AlaCarteItem> mi2 = new ArrayList<AlaCarteItem>();
		mi2.add(menuList.get(3));
		mi2.add(menuList.get(4));
		
		ArrayList<AlaCarteItem> mi3 = new ArrayList<AlaCarteItem>();
		mi3.add(menuList.get(0));
		mi3.add(menuList.get(6));
		
		
		ArrayList<Promotion> plist = new ArrayList<Promotion>(); 
		plist.add((new Promotion(mi, "Promo 1", 35.50, 1, "This is a test desc")));
		plist.add((new Promotion(mi2, "Promo 2", 35.50, 2, "This is a test desc")));
		plist.add((new Promotion(mi3, "Promo 3", 35.50, 3, "This is a test desc")));
		plist.add((new Promotion(menuList, "Promo 4", 35.50, 4, "This is a test desc")));
		plist.add((new Promotion(menuList, "Promo 5", 35.50, 5, "This is a test desc")));
		plist.add((new Promotion(menuList, "Promo 6", 35.50, 6, "This is a test desc")));
		DataManager.writeSerializedObject("PromoItem.db",plist);
		
		
	}
	
	//Moon
	public void changeTblStatus()
	{
		
	}
	
	public void printPromoItem()
	{	
		promoList = new ArrayList<Promotion>();
		promoList= (ArrayList) DataManager.readSerializedObject("PromoItem.db");
	
	//	System.out.println("   Promo Item     |     Promo Name      |    Promo Price (SGD)   |  PromoID \n" + promoList);
		//Scanning 
		   
	}

	public void createwriteData()
	{
		
		ArrayList<AlaCarteItem> list = new ArrayList<AlaCarteItem>();
		list.add(new AlaCarteItem( "New York Burger", 20.00 , 1, "Best New York Burger with 22 ounces of ground beef", Type.mains));
		list.add(new AlaCarteItem( "Singapore Burger", 25.00 , 2, "The best nasi lemak burger you will ever taste", Type.mains));
		list.add(new AlaCarteItem( "Game of Thrones Burger", 30.00 , 3, "For GOT fans with 33 ounces of ground beef", Type.mains));
		list.add(new AlaCarteItem( "Stake Fries", 3.50 , 4, "Fries cooked in beef steak", Type.sides));
		list.add(new AlaCarteItem( "Stake Fries", 3.50 , 5, "Fries cooked in beef steak", Type.sides));
		list.add(new AlaCarteItem( "Ice Lemon Tea", 2.00 , 6, "Liptons Ice Lemon Tea", Type.drinks));
		list.add(new AlaCarteItem( "Peppermint Green Tea", 2.00 , 7, "Liptons Ice Lemon Tea", Type.drinks));
		list.add(new AlaCarteItem( "Ice Peach Tea", 2.00 , 8, "Liptons Ice Peach Tea", Type.drinks));
		//MenuItem mi = new MenuItem();
		//scanner input
		//mi.setName("userInput");
		//list.add(mi);
		DataManager.writeSerializedObject("MenuItems.db", list);
		
		
	}
	
	public void createResBooking(String session, String name, int pax, int contact_no, int tableID)
	{
		//Scanning 
		
		
	}
	
	public void checkTableAvail()
	{
		//Read from DB/Arraylist 
		//Check against no of pax 
		//Check against available tables 
	}
	
	public void updateTableAvail()
	{
		
	}
	
	public void checkRes(int contactNo)
	{
		//Prompt contactNo
		//Read from reservations.db 
		// Loop to check if contactNo == reservations DB 
		// if(match), display the data 

	}
	
	public void removeRes(int contactNo)
	{
		//Prompt contactNo
		//Read from reservations.db 
		// Loop to check if contactNo == reservations DB 
		// if(match), then delete 
		// Write back to DB 

	}
	
	public void payPrintBill(){
//		orderList.add(new Ordering(1, 1, 1, menuList, "PAID", getcurrentDate(), 1080));
//		orderList.add(new Ordering(2, 2, 1, menuList, "PAID", getcurrentDate(), 1080));
//		orderList.add(new Ordering(3, 5, 1, menuList, "PAID", getcurrentDate(), 1008));
//		orderList.add(new Ordering(4, 6, 1, menuList, "PAID", getcurrentDate(), 1006));
//		orderList.add(new Ordering(5, 10, 1, menuList, "PAID", getcurrentDate(), 1001));
//		orderList.add(new Ordering(6, 23, 1, menuList, "PAID", getcurrentDate(), 1003));
//		DataManager.writeSerializedObject("OrderHistory.db",orderList);
		//orderList.add(new Ordering(1, 1, 1, menuList, "unPAID", getcurrentDate(), 1003));

		OrderHistory oh = new OrderHistory();
		
		System.out.println("What is your table number?, Press -1 to back");
		boolean Notsuccess = true;
		
		do{
			int tableid = customScanner.readOnlyIntegers(sc);
			if(tableid==-1){
				return;
			}
			for(Ordering o:orderList){			
				if(o.getTableID()==tableid){
					o.setStatus("PAID");
					
					o.printOrderInvoice();
					
					oh.updateHistory(o);
					orderList.remove(o);
					Notsuccess=false;
					break;
				}
			}
			if(Notsuccess)
				System.out.println("Incorrect TableID please try again!, Press -1 to back");
		}while(Notsuccess);
	}
	
	public void printReport(){
		Date startdate = null;
		Date enddate = null;
		double totalRevenue = 0;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String sd="";
		boolean Notsuccess = true;
		do{
			//Scan for start date
			System.out.println("Enter start date (dd/MM/yy), Press -1 to back");
			sd=sc.nextLine();
			if(sd.equals("-1"))
				return;
			try {
				startdate=formatter.parse(sd);
				Notsuccess=false;
			} catch (ParseException e) {
				System.out.println("Invalid start Date, Try again!");
			}
		}while(Notsuccess);
		
		do{
			//Scan for end date
			System.out.println("Enter end date (dd/MM/yy), Press -1 to back");
			sd=sc.nextLine();
			if(sd.equals("-1"))
				return;
			try {
				enddate=formatter.parse(sd);
				Notsuccess=false;
			} catch (ParseException e) {
				System.out.println("Invalid end Date, Try again!");
			}
		}while(Notsuccess);
		
		System.out.println("Revenue report on "+formatter.format(startdate)+" to "+formatter.format(enddate));
		ArrayList<Ordering> orHistory = (ArrayList) DataManager.readSerializedObject("OrderHistory.db");
		System.out.println("   Date  |   StaffID    |   OrderID   |     Price   ");
		for (Ordering order:orHistory){
			Date inDate = order.getDate();
			System.out.print(""+formatter.format(inDate)+" |");
			if ( (inDate.after(startdate) && inDate.before(enddate))
					||(formatter.format(inDate).equals(formatter.format(startdate)))
					||(formatter.format(inDate).equals(formatter.format(enddate)))){
				totalRevenue+=order.getTotalPrice();
				System.out.print(order);
			}
		}
		System.out.println("Total Revenue : "+ totalRevenue);
	}
}
