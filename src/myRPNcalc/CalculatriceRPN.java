package myRPNcalc;

import java.util.EmptyStackException;

public class CalculatriceRPN {

	public static void main(String[] args) {
		
		MoteurRPN m = new MoteurRPN();
		SaisieRPN s = new SaisieRPN();
		
		while(true)
		{
			try
			{
				m.executeCommand(s.WaitInput());
				m.ShowStack();
			}
			catch(EmptyStackException e1)
			{
				System.out.println("Pile vide !");
			}
		}
	}

}
