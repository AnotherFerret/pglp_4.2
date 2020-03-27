package myRPNcalc;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {
	
	private Interpreteur it;
	private Stack<Double> operande; 
	
	public MoteurRPN() 
	{
		it = Interpreteur.init();
		operande = new Stack<Double>();
		it.addCommand("+", () -> operande.push(operande.pop() + operande.pop()) );
		it.addCommand("-", () -> operande.push(-(operande.pop() - operande.pop())) );
		it.addCommand("*", () -> operande.push(operande.pop() * operande.pop()) );
		it.addCommand("/", () -> operande.push(1/operande.pop() * operande.pop()) );
	}
	
	public void listCommands() {
		
		it.listCommands();
	}
	
	public Double executeCommand(String name)
	{
		return it.executeCommand(name);
		
	}
	
	public void AddOP(Double op)
	{
		operande.push(op);
	}
	
	public double PopValue()
	{
		return operande.peek();
	}
	
	public void ShowStack()
	{
		System.out.println(operande.toString());
	}

}
