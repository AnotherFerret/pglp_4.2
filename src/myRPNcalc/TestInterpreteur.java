package myRPNcalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInterpreteur {
	
	@Test
	public void testCalcul()
	{
		MoteurRPN m = new MoteurRPN();
		m.addOP((double)3);
		m.addOP((double)5);
		m.executeCommand("+");
		m.addOP((double)5);
		m.executeCommand("-");
		m.addOP((double)5);
		m.executeCommand("*");
		m.addOP((double)5);
		m.executeCommand("/");
		assertEquals(m.popValue(), 3.0, 0);
	}
	
	@Test
	public void testUndo()
	{
		MoteurRPN m = new MoteurRPN();
		m.addOP((double)3);
		m.addOP((double)5);
		m.addOP((double)7);
		m.executeCommand("undo");
		assertEquals(m.popValue(), 5.0, 0);
	}
	
	@Test
	public void testUndoOperations()
	{
		MoteurRPN m = new MoteurRPN();
		m.addOP((double)3);
		m.addOP((double)5);
		m.addOP((double)7);
		m.executeCommand("+");
		m.executeCommand("-");
		m.executeCommand("undo");
		assertEquals(m.popValue(), 12.0, 0);
	}

}
