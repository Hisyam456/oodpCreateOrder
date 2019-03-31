package Class;

import java.util.ArrayList;

import Data.DataManager;

public class OrderHistory {
	ArrayList<Ordering> orderHistory = new ArrayList<Ordering>();
	
	public OrderHistory(){
		this.orderHistory = (ArrayList) DataManager.readSerializedObject("OrderHistory.db");
	}
	
	public void updateHistory(Ordering orderHistory){
		this.orderHistory.add(orderHistory);
		DataManager.writeSerializedObject("OrderHistory.db",this.orderHistory);
	}
	
}
