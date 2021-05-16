package fr.ouwox.ccore.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.ouwox.ccore.Main;

public class AtoutCommands implements CommandExecutor{
	String prefix;
	
	//-----------------------------//
	
	String speednom;
	String firenom;
	String forcenom;
	String jumpnom;
	String regennom;
	
	//-----------------------------//
	
	List<String> speedloreall;
	List<String> fireloreall;
	List<String> forceloreall;
	List<String> jumpboostloreall;
	List<String> regenloreall;
	
	//-----------------------------//
	
	int menu;
	int placespeed;
	int placeforce;
	int placefire;
	int placejump;
	int placeregen;
	int color;
	
	//-----------------------------//
	Main plugin;

	public AtoutCommands(Main plugin) {
		this.prefix = Main.cfg.getString("prefix").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		
		//------------------------------------------------------------------------------------------------------------------//
		
		this.menu = Main.cfg.getInt("menu");
		this.color = Main.cfg.getInt("couleur-vitre");
		
		//------------------------------------------------------------------------------------------------------------------//
		
		this.speednom = Main.cfg.getString("speed.nom").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		this.firenom = Main.cfg.getString("fire.nom").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		this.forcenom = Main.cfg.getString("force.nom").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		this.jumpnom = Main.cfg.getString("jumpboost.nom").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		this.regennom = Main.cfg.getString("regeneration.nom").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		
		//------------------------------------------------------------------------------------------------------------------//
		
		this.placespeed = Main.cfg.getInt("speed.place");
		this.placeforce = Main.cfg.getInt("force.place");
		this.placefire = Main.cfg.getInt("fire.place");
		this.placejump = Main.cfg.getInt("jumpboost.place");
		this.placeregen = Main.cfg.getInt("regeneration.place");
		
		//------------------------------------------------------------------------------------------------------------------//
		
		this.speedloreall = Main.cfg.getStringList(("speed.lore").replaceAll("&", "§"));
		this.forceloreall = Main.cfg.getStringList(("force.lore").replaceAll("&", "§"));
		this.fireloreall = Main.cfg.getStringList(("fire.lore").replaceAll("&", "§"));
		this.jumpboostloreall = Main.cfg.getStringList(("jumpboost.lore").replaceAll("&", "§"));
		this.regenloreall = Main.cfg.getStringList(("regeneration.lore").replaceAll("&", "§"));
		
		//------------------------------------------------------------------------------------------------------------------//
		
		plugin.getCommand("atouts").setExecutor(this);
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player)sender;
			
			//-------------------------------------------------------------------------//
			
			Inventory inv = Bukkit.createInventory(null, menu, this.prefix);
			
			//---------------------------------[SPEED]---------------------------------//
			
			ItemStack n1 = new ItemStack(Material.SUGAR, 1);
			ItemMeta n1m = n1.getItemMeta();
			List<String> loreList = new ArrayList<String>();
			loreList.addAll(speedloreall);
			n1m.setDisplayName(this.speednom);
			n1m.setLore(loreList);
			n1.setItemMeta(n1m);
			inv.setItem(placespeed, n1);
			
			//---------------------------------[FIRE RESISTANCE]---------------------------------//
			
			ItemStack n2 = new ItemStack(Material.MAGMA_CREAM, 1);
			ItemMeta n2m = n2.getItemMeta();
			List<String> loreList2 = new ArrayList<String>();
			loreList2.addAll(fireloreall);
			n2m.setDisplayName(this.firenom);
			n2m.setLore(loreList2);
			n2.setItemMeta(n2m);
			inv.setItem(placefire, n2);
			
			//---------------------------------[FORCE]---------------------------------//
			
			ItemStack n3 = new ItemStack(Material.BLAZE_POWDER, 1);
			ItemMeta n3m = n3.getItemMeta();
			List<String> loreList3 = new ArrayList<String>();
			loreList3.addAll(forceloreall);
			n3m.setDisplayName(this.forcenom);
			n3m.setLore(loreList3);
			n3.setItemMeta(n3m);
			inv.setItem(placeforce, n3);
			
			//---------------------------------[JUMP BOOST]---------------------------------//
			
			ItemStack n4 = new ItemStack(Material.FEATHER, 1);
			ItemMeta n4m = n4.getItemMeta();
			List<String> loreList4 = new ArrayList<String>();
			loreList4.addAll(jumpboostloreall);
			n4m.setDisplayName(this.jumpnom);
			n4m.setLore(loreList4);
			n4.setItemMeta(n4m);
			inv.setItem(placejump, n4);
			
			//---------------------------------[REGEN]---------------------------------//
			
			ItemStack n5 = new ItemStack(Material.GOLDEN_APPLE, 1);
			ItemMeta n5m = n5.getItemMeta();
			List<String> loreList5 = new ArrayList<String>();
			loreList5.addAll(regenloreall);
			n5m.setDisplayName(this.regennom);
			n5m.setLore(loreList5);
			n5.setItemMeta(n5m);
			inv.setItem(placeregen, n5);
			
			//-------------------------------------------------------------------------//
			
			p.openInventory(inv);
			
			//-------------------------------------------------------------------------//
			
			ItemStack st = new ItemStack(Material.STAINED_GLASS_PANE, 1 , (byte)color);
			ItemMeta stt = st.getItemMeta();
			stt.setDisplayName(" ");
			st.setItemMeta(stt);

			for(int i = 0; i < inv.getSize(); ++i) {
				if (inv.getItem(i) == null) {
					inv.setItem(i, st);
				}
			}
		}

		return false;
	}
}
