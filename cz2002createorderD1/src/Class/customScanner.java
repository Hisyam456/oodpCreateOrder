package Class;

import java.util.Scanner;

public class customScanner {
	customScanner(){
		
	}
	public static int readOnlyIntegers(Scanner sc) 
    {
        int integer = 0;
            try
                {
                    integer = sc.nextInt();
                    sc.nextLine();
                }
                catch(Exception e)
                {
                	//Moon
                    System.out.println("ERROR: only numbers are allowed");
                    sc.nextLine();
                    integer = readOnlyIntegers(sc);
                }
        return integer;
    }
	
	public static double readOnlyDoubles(Scanner sc) 
    {
        double doubles = 0;
            try
                {
              doubles = sc.nextDouble();
                    sc.nextDouble();
                }
                catch(Exception e)
                {
                	//Moon
                    System.out.println("ERROR: only numbers are allowed");
                    sc.nextLine();
                    doubles = readOnlyDoubles(sc);
                }
        return doubles;
    }
	
	//Moon
	// Takes in the scanner and returns the correct input id
	public static int checkId(Scanner sc)
	{
		int id = 0;
		int length = 0;
		
		try
		{
		 id = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("ERROR: only numbers are allowed");
			sc.nextLine();
            id = checkId(sc);
		}
		
		int idCopy = id;
	
		while(idCopy > 0)
        {
        	idCopy = idCopy / 10;
        	length++;
        }
		
		if( length != 5)
		{
			System.out.println("ERROR: StaffID must contain 5 digits.");
			System.out.print("Enter StaffId: ");
            id = checkId(sc);
		} 

		return id;
	}
}
