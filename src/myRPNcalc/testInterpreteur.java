package myRPNcalc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class testInterpreteur {

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();	
	
	@Test
	public void testUndo() {
		Interpreteur it = Interpreteur.init();
		Double test = 1.0;
		assertEquals(it.executeCommand("undo"), test, 0);
	}
	
	@Test
	public void testExit() {
		Interpreteur it = Interpreteur.init();
		exit.expectSystemExit();
		it.executeCommand("exit");
		fail();
	}
	
	@Test
	public void testCalcul()
	{
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
		assertEquals(m.PopValue(), 3.0, 0);
	}

}
