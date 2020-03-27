package myRPNcalc;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {

	private final Map<String, Commande> commands;
	
	protected Interpreteur()
	{
		this.commands = new HashMap<>();
	}
	
	public void addCommand(String name, Commande command)
	{
		this.commands.put(name,  command);
	}
	
	public int executeCommand(String name)
	{
		if(this.commands.containsKey(name))
		{
			return this.commands.get(name).apply();
		}
		return 0;
	}
	
	public static Interpreteur init()
	{
		Interpreteur i = new Interpreteur();
		i.addCommand("exit", () -> {System.exit(0); return 1;} );
		i.addCommand("undo", () -> {System.out.println("undoing"); return 1;} );
		return i;
	}
}
