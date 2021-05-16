package fr.ouwox.ccore.Listener;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import fr.ouwox.ccore.Main;

public class EventManager implements Listener{
	public static void registerEvents(Main main) {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Join(), main);
		pm.registerEvents(new AtoutsEffect(), main);
		pm.registerEvents(new AtoutDisable(), main);
	}
}
