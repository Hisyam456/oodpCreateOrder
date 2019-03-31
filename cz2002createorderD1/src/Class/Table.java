package Class;

import java.io.Serializable;

public class Table implements Serializable{
	private String status;
	private int tableID;
	private int pax;
	private int contactNo;
	
	public Table(int tableID, String status, int pax, int contactNo) {
		super();
		this.status = status;
		this.tableID = tableID;
		this.pax = pax;
		this.contactNo = contactNo; // Why is there a contact number in tables.java? Should'nt it be in reservation?
		//^should be not needed but keep it first
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public int getPax() {
		return pax;
	}
	public void setPax(int pax) {
		this.pax = pax;
	}
	
	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String toString(){
		return (	
			"         "+tableID+"     |     "+status+ "     |        "+pax+"      \n"
					);
}
	
}
