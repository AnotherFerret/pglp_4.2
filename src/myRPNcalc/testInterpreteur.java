package myRPNcalc;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class testInterpreteur {

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();	
	
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
		m.AddOP((double)5);
		m.executeCommand("-");
		m.AddOP((double)5);
		m.executeCommand("*");
		m.AddOP((double)5);
		m.executeCommand("/");
		assertEquals(m.PopValue(), 3.0, 0);
	}
	
	@Test
	public void testUndo()
	{
		MoteurRPN m = new MoteurRPN();
		m.AddOP((double)3);
		m.AddOP((double)5);
		m.AddOP((double)7);
		m.executeCommand("undo");
		assertEquals(m.PopValue(), 5.0, 0);
	}
	
	@Test
	public void testUndoOperations()
	{
		MoteurRPN m = new MoteurRPN();
		m.AddOP((double)3);
		m.AddOP((double)5);
		m.AddOP((double)7);
		m.executeCommand("+");
		m.executeCommand("-");
		m.executeCommand("undo");
		assertEquals(m.PopValue(), 12.0, 0);
	}

}
