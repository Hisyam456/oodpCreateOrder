package Class;

import java.util.ArrayList;

public class MainMenu {
	ArrayList <AlaCarteItem> menuitem; 
	ArrayList<Promotion> promoitem;
	
	public ArrayList<AlaCarteItem> getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(ArrayList<AlaCarteItem> menuitem) {
		this.menuitem = menuitem;
	}
	public ArrayList<Promotion> getPromoitem() {
		return promoitem;
	}
	public void setPromoitem(ArrayList<Promotion> promoitem) {
		this.promoitem = promoitem;
	}
	
	public void printListMenuItem()
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		   System.out.printf("%-15s %-28s %-60s %-15s %-3s", "ITEM ID", "ITEM NAME", "ITEM DESCRIPTION", "ITEM CATEGORY", "ITEM PRICE");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		    
		    if(menuitem == null || menuitem.isEmpty()){
		    	System.out.println("No Menu Item");
		    }
		    for(AlaCarteItem student: menuitem){
		        System.out.format("%-15d %-28s %-60s %-15s %-3f",
		                student.getMenuID(),student.getName(), student.getDesc(), student.getCat(), student.getPrice());
		        System.out.println();
		    }
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
	
	public void printpromoItem()
	{
		 System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		   System.out.printf("%-15s %-28s %-60s %-3s", "PROMO ID", "PROMO NAME", "PROMO DESCRIPTION", "PROMO PRICE");
		    System.out.println();
		    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	    
	    if(promoitem == null || promoitem.isEmpty()){
	    	System.out.println("No promotion Item");
		}
		    
	    for(Promotion p : promoitem) {
	    	System.out.printf("%-15d %-28s %-60s %-3f", p.getPromoID(), p.getName(), p.getDesc(), p.getPrice());
	    	System.out.println();
	    	for(AlaCarteItem pm: p.getMenuItem()){
		        System.out.format("%-15s %-28s %-60s %-15s",
		                " ",pm.getName(), pm.getDesc(), pm.getCat());
		        System.out.println();
		    }
	    	
	    	System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	   
	    }
	    
	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
	    
	}
}
