package myRPNcalc;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {
	
	Interpreteur it;
	Stack<Integer> operande; 
	
	public MoteurRPN() 
	{
		it = Interpreteur.init();
		operande = new Stack<Integer>();
	}
	
	public void AddOP(Integer op)
	{
		operande.push(op);
	}

}
