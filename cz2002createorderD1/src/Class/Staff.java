package Class;

import java.io.Serializable;

public class Staff implements Serializable{
	private String Name;
	private String Gender;
	private String EmployeeID;
	private String JobTitle;
	
	public String toString(){
			return (	
				"         "+Name+"       |     "+Gender+ "     |        "+EmployeeID+"       |   "+JobTitle+"\n"
						);
	}

}
