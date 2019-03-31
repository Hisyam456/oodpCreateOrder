package Class;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Reservation {
	private String session; //AM/PM
	private Timestamp dateTime;
	private int contactNo; 
	private int pax; 
	private String name; 
	private int tableID;
	
	/*public Reservation(String session, int tableID, int employeeID,
			ArrayList<MenuItem> menuID, String status, Date date, int qty) {
		super();
		this.orderID = orderID;
		this.tableID = tableID;
		this.employeeID = employeeID;
		this.menuID = menuID;
		this.status = status;
		this.date = date;
		this.qty = qty;
	} */
	
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public int getPax() {
		return pax;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	} 
	
}
