package myRPNcalc;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {

	private final Map<String, Commande> commands;
	
	private Interpreteur()
	{
		this.commands = new HashMap<>();
	}
	
	public void addCommand(String name, Commande command)
	{
		this.commands.put(name,  command);
	}
	
	public void executeCommand(String name)
	{
		if(this.commands.containsKey(name))
		{
			this.commands.get(name).apply();
		}
	}
	
	public static Interpreteur init()
	{
		Interpreteur i = new Interpreteur();
		i.addCommand("exit", () -> System.out.println("shuting down"));
		i.addCommand("undo", () -> System.out.println("undoing"));
		return i;
	}
}
