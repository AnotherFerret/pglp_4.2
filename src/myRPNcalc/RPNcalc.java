package myRPNcalc;

public class RPNcalc {

	public static void main(String[] args) {
		
		Interpreteur it = Interpreteur.init();
		System.out.println(it.executeCommand("undo"));
		System.out.println(it.executeCommand("exit"));
		
		
		

	}

}
