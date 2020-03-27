package myRPNcalc;

public class RPNcalc {

	public static void main(String[] args) {
		
		MoteurRPN m = new MoteurRPN();
		m.AddOP((double)3);
		m.AddOP((double)5);
		m.executeCommand("+");
		m.ShowStack();
		m.AddOP((double)5);
		m.executeCommand("-");
		m.ShowStack();
		m.AddOP((double)5);
		m.executeCommand("*");
		m.ShowStack();
		m.AddOP((double)5);
		m.ShowStack();
		m.executeCommand("/");
		m.ShowStack();

	}

}
