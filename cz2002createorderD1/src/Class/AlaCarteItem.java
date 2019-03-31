package Class;

import java.io.Serializable;
import java.util.ArrayList;

public class AlaCarteItem implements Serializable{
	private String name; 
	private double price; 
	private int menuID; 
	private String desc;
	private Type cat;
	
	public AlaCarteItem(String name, double price, int menuID, String desc, Type cat) {
		super();
		this.name = name;
		this.price = price;
		this.menuID = menuID;
		this.desc = desc;
		this.cat = cat;
	}
	public AlaCarteItem() {
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
	
	public void printMenuItems(ArrayList<AlaCarteItem> menuList){
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		   System.out.printf("%-15s %-28s %-60s %-15s %-3s", "ITEM ID", "ITEM NAME", "ITEM DESCRIPTION", "ITEM CATEGORY", "ITEM PRICE");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    
		    for(AlaCarteItem student: menuList){
		        System.out.format("%-15d %-28s %-60s %-15s %-3f",
		                student.getMenuID(),student.getName(), student.getDesc(), student.getCat(), student.getPrice());
		        System.out.println();
		    }
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
	
	
	public String toString(){
		return (	
			"         "+name+"       |     "+price+ "     |        "+menuID+"       |   "+desc+"		|        "+cat+"\n"
					);
}
	
}
