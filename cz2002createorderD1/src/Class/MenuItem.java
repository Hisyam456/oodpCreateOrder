package Class;

import java.io.Serializable;

public class MenuItem implements Serializable{
	private String name; 
	private double price; 
	private int menuID; 
	private String desc;
	private Type cat;
	
	public MenuItem(String name, double price, int menuID, String desc, Type cat) {
		super();
		this.name = name;
		this.price = price;
		this.menuID = menuID;
		this.desc = desc;
		this.cat = cat;
	}
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Type getCat() {
		return cat;
	}
	public void setCat(Type cat) {
		this.cat = cat;
	} 
	
	public void printMenuItems(){
		System.out.println("Menu "+menuID);
		System.out.println("List of items and packages:");
		System.out.println(this);
	}
	
	
	public String toString(){
		return (	
			"         "+name+"       |     "+price+ "     |        "+menuID+"       |   "+desc+"		|        "+cat+"\n"
					);
}
	
}
