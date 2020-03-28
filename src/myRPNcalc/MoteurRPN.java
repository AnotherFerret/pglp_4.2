package myRPNcalc;

import java.util.Stack;

public class MoteurRPN extends Interpreteur {
	
	private Interpreteur it;
	private Stack<Double> operande; 
	private Stack<Commande> commands;
	
	public MoteurRPN() 
	{
		it = Interpreteur.init();
		operande = new Stack<Double>();
		commands = new Stack<Commande>();
		it.addCommand("+", () -> {	if(operande.size() >= 2){
									double a1 = operande.pop(); 
									double a2 = operande.pop();
									operande.push(a1+a2); 
									commands.push(() -> {operande.pop(); 
														 operande.push(a2);
														 operande.push(a1);
														 return 1.0;});
									return 1.0;} return 0.0;});

		it.addCommand("-", () -> {	if(operande.size() >= 2){
										double a1 = operande.pop(); 
										double a2 = operande.pop();
										operande.push(a2-a1); 
										commands.push(() -> {operande.pop(); 
															 operande.push(a2);
															 operande.push(a1);
															 return 1.0;});
										return 1.0;} 
									return 0.0;}
									);
		
		it.addCommand("*", () -> {	if(operande.size() >= 2) 
									{
										double a1 = operande.pop(); 
										double a2 = operande.pop();
										operande.push(a2*a1); 
										commands.push(() -> {operande.pop(); 
															 operande.push(a2);
															 operande.push(a1);
															 return 1.0;});
										return 1.0;} 
									return 0.0;}
									);
		
		it.addCommand("/", () -> {	if(operande.size() >= 2)
									{
										double a1 = operande.pop(); 
										double a2 = operande.pop();
										operande.push(a2/a1); 
										commands.push(() -> {operande.pop(); 
															 operande.push(a2);
															 operande.push(a1);
															 return 1.0;});
										return 1.0;} 
									return 0.0;}
									);
		it.addCommand("undo", () -> commands.pop().apply() );
	}
	
	public void listCommands() {
		
		it.listCommands();
	}
	
	public Double executeCommand(String name)
	{
		try
		{
			addOP(Double.parseDouble(name));
		}
		catch(NumberFormatException e)
		{
			it.executeCommand(name);
		}
		return 1.0;

	}
	
	public void addOP(Double op)
	{
		operande.push(op);
		commands.push( () -> operande.pop() );
	}
	
	public double popValue()
	{
		return operande.peek();
	}
	
	public void showStack()
	{
		System.out.println(operande.toString());
	}

}
