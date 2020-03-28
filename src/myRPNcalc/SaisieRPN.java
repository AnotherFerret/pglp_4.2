package myRPNcalc;

import java.util.Scanner;

public class SaisieRPN {

	Scanner sc;
	
	public SaisieRPN() 
	{
		 sc = new Scanner(System.in, "UTF-8");
	}
	
	public String waitInput()
	{
		return sc.nextLine();
	}
}
