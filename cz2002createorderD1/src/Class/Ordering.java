package Class;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;


public class Ordering implements Serializable {
	private int orderID; 
	private int tableID; 
	private int employeeID;
	private MainMenu menuList;
	private String status; 
	private Date date; 
	private double totalPrice;


	public Ordering(int orderID, int tableID, int employeeID,
			MainMenu menuList, String status, Date date, double totalPrice) {
		super();
		this.orderID = orderID;
		this.tableID = tableID;
		this.employeeID = employeeID;
		this.menuList = menuList;
		this.status = status;
		this.date = date;
		this.totalPrice = totalPrice;
	}
	
	public Ordering cloning(Ordering o) {
	     o.setOrderID(this.orderID);
	     o.setTableID(this.tableID);
	     o.setEmployeeID(this.employeeID);
	     o.setMenuList(this.menuList);
	     o.setStatus(this.status);
	     o.setDate(this.date);
	     o.setTotalPrice(this.totalPrice);
	     
	     return o;
	}
	
	public Ordering() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public MainMenu getMenuList() {
		return menuList;
	}
	public void setMenuList(MainMenu menuList) {
		this.menuList = menuList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double totalPrice() {
		return totalPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public void printOrderInvoice(){
		System.out.println("Order "+orderID);
		
		System.out.println("List of items and packages:");
		//System.out.println(this);
		
	}

	private String toString(String string) {
		return "asdfasdfadsf";
	
	}
	
	public String toString(){
		return (	
			"      " + employeeID + "       |      " +orderID+"      |     "+     totalPrice     +"\n"
					);
	}
	
	// Moon
	public void printOrderInput()
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-15s %-15s %-15s %-30s %-3s", "STAFF ID", "ORDER ID", "STATUS", "DATE", "COST");
	    System.out.println();
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	    
    
    	//This is a function that return the Alacare item from the menulsit or the main menu arraylist form order object
        System.out.format("%-15d %-15d %-15s %-30s %-3f", this.getEmployeeID(), this.getOrderID(), this.getStatus(), this.getDate(), this.getTotalPrice());
        System.out.println();
        //Ordering(int orderID, int tableID, int employeeID, MainMenu menuList, String status, Date date, double totalPrice)

	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	
	    // If there is a menu order
	    if(this.getMenuList().getMenuitem() != null || !(this.getMenuList().getMenuitem().isEmpty()))
	    {
	    	this.getMenuList().printListMenuItem();
	    }
	    
	    // If there is a promo order
	    if(this.getMenuList().getPromoitem() != null || !(this.getMenuList().getPromoitem().isEmpty()))
	    {
	    	this.getMenuList().printpromoItem();
	    }
	}
	
	
}
