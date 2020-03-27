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
		assertEquals(it.executeCommand("undo"), test);
	}
	
	@Test
	public void testExit() {
		Interpreteur it = Interpreteur.init();
		exit.expectSystemExit();
		it.executeCommand("exit");
		fail();
	}

}
