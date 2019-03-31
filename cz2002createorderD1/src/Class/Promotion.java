package Class;
import java.io.Serializable;

import java.util.ArrayList;

public class Promotion implements Serializable{
	private ArrayList<AlaCarteItem> menuItem;
	private String name; 
	private double price; 
	private int promoID; 
	private String desc; 

	public Promotion(ArrayList<AlaCarteItem> menuID, String name, double price, int promoID, String desc)
	{
		super(); 
		this.menuItem = menuID;
		this.name = name; 
		this.price = price; 
		this.promoID = promoID;
		this.desc = desc;
		
	}
	
	public ArrayList<AlaCarteItem> getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(ArrayList<AlaCarteItem> menuItem) {
		this.menuItem = menuItem;
	}
	public int getPromoID() {
		return promoID;
	}
	public void setPromoID(int promoID) {
		this.promoID = promoID;
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
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString(){
		return (	
			"     "+name+ "     |        "+price+"       |   "+promoID+"\n"+
		menuItem+"\n"
					);
}
	
}
