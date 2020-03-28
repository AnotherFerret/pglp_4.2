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
	
	public Double executeCommand(String name)
	{
		if(this.commands.containsKey(name))
		{
			return this.commands.get(name).apply();
		}
		System.out.println("Commande introuvable");
		return 0.0;
	}
	
	public void listCommands() {
		System.out.println("Commandes :");
		this.commands.keySet().stream().forEach(System.out::println);
	}
	
	public static Interpreteur init()
	{
		Interpreteur i = new Interpreteur();
		i.addCommand("exit", () -> {System.exit(0); return 1.0;} );
		i.addCommand("undo", () -> {System.out.println("undoing"); return 1.0;} );
		return i;
	}
}
