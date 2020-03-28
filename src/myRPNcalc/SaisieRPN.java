package myRPNcalc;

import java.util.Scanner;

public class SaisieRPN {

	Scanner sc;
	
	public SaisieRPN() 
	{
		 sc = new Scanner(System.in);
	}
	
	public String WaitInput()
	{
		return sc.nextLine();
	}
}
