package fr.ouwox.ccore;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fr.ouwox.ccore.Listener.EventManager;
import fr.ouwox.ccore.commands.AtoutCommands;

public class Main extends JavaPlugin implements Listener {
	public static Main instance;
	public static File config;
	public static FileConfiguration cfg;

	public void onEnable() {

		System.out.println("The plugin cAtout has been enabled");
		System.out.println("Le plugin cAtout a été activé !");

		this.getConfig().options().copyDefaults(true);
		this.saveDefaultConfig();
		    EventManager.registerEvents(this);
			instance = this;
			config = new File("plugins/cAtout", "config.yml");
			cfg = YamlConfiguration.loadConfiguration(config);
			new AtoutCommands(this);
		
	}


}