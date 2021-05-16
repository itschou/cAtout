package fr.ouwox.ccore.Listener;

import fr.ouwox.ccore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AtoutsEffect implements Listener {

	static Map<UUID, Boolean> effets = new HashMap();
	static Map<UUID, Boolean> effetf = new HashMap();
	static Map<UUID, Boolean> effetfi = new HashMap();
	static Map<UUID, Boolean> effetre = new HashMap();
	static Map<UUID, Boolean> effetju = new HashMap();

	@EventHandler
	public void click(InventoryClickEvent e) {
		
		//-------------------------------------------------[ PFEFIX ]-------------------------------------------------//
		
		String prefix = Main.cfg.getString("prefix").replaceAll("&", "§");
		
		//-------------------------------------------------[ FORCE ]-------------------------------------------------//
		
		String forceperm = Main.cfg.getString("force.perm");
		String forcenoperm = Main.cfg.getString("force.noperm").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		String forcemsg = Main.cfg.getString("force.msg").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		int forcein = Main.cfg.getInt("force.intensite");
		
		//-------------------------------------------------[ SPEED ]-------------------------------------------------//
		
		String speedperm = Main.cfg.getString("speed.perm");
		String speednoperm = Main.cfg.getString("speed.noperm").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		String speedmsg = Main.cfg.getString("speed.msg").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		int speedin = Main.cfg.getInt("speed.intensite");
		
		//-------------------------------------------------[ FIRE ]-------------------------------------------------//
		
		String fireperm = Main.cfg.getString("fire.perm");
		String firenoperm = Main.cfg.getString("fire.noperm").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		String firemsg = Main.cfg.getString("fire.msg").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		int firein = Main.cfg.getInt("fire.intensite");
		
		//-------------------------------------------------[ JUMP ]-------------------------------------------------//
		
		String jumpperm = Main.cfg.getString("jumpboost.perm");
		String jumpnoperm = Main.cfg.getString("jumpboost.noperm").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		String jumpmsg = Main.cfg.getString("jumpboost.msg").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		int jumpin = Main.cfg.getInt("jumpboost.intensite");
		
		//-------------------------------------------------[ REGEN ]-------------------------------------------------//
		
		String regenperm = Main.cfg.getString("regeneration.perm");
		String regennoperm = Main.cfg.getString("regeneration.noperm").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		String regenmsg = Main.cfg.getString("regeneration.msg").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§");
		int regenin = Main.cfg.getInt("regeneration.intensite");
		
		//------------------------------------------------------------------------------------------------------------------//
		
		Inventory inv = e.getInventory();
		Player player = (Player)e.getWhoClicked();
		
		//------------------------------------------------------------------------------------------------------------------//
		ItemStack c = e.getCurrentItem();
		if (c != null) {
			if (inv.getName().equalsIgnoreCase(prefix)) {

				//-------------------------------------------------[ SPEED ]-------------------------------------------------//
				
				if (c.getType() == Material.SUGAR) {
					if (player.hasPermission(speedperm)){
					if (effets.get(player.getUniqueId()) == Boolean.FALSE) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10000000, speedin));
						player.sendMessage(prefix + " " + speedmsg);
						effets.put(player.getUniqueId(), true);
						}else {
							player.sendMessage(prefix + " " + Main.cfg.getString("effect-erreur").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§"));
						}
					}
					if (!(player.hasPermission(speedperm))){
						player.sendMessage(prefix + " " + speednoperm);
					}
						e.setCancelled(true);
					}




				//-------------------------------------------------[ FIRE ]-------------------------------------------------//
				
				if (c.getType() == Material.MAGMA_CREAM) {
					if (player.hasPermission(fireperm)){
					if (effetfi.get(player.getUniqueId()) == Boolean.FALSE) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000000, firein));
						player.sendMessage(prefix + " " + firemsg);
						effetfi.put(player.getUniqueId(), true);
					} else {
						player.sendMessage(prefix + " " + Main.cfg.getString("effect-erreur").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§"));
					}
					}
					if (!(player.hasPermission(fireperm))){
						player.sendMessage(prefix + " " + firenoperm);
					}
					e.setCancelled(true);
				}

				//-------------------------------------------------[ FORCE ]-------------------------------------------------//

				if (c.getType() == Material.BLAZE_POWDER) {
					if (player.hasPermission(forceperm)){
					if (effetf.get(player.getUniqueId()) == Boolean.FALSE) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10000000, forcein));
						player.sendMessage(prefix + " " + forcemsg);
						effetf.put(player.getUniqueId(), true);
					} else {
						player.sendMessage(prefix + " " + Main.cfg.getString("effect-erreur").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§"));
					}
				}
					if (!(player.hasPermission(forceperm))){
						player.sendMessage(prefix + " " + forcenoperm);
					}
					e.setCancelled(true);
				}
				
				//-------------------------------------------------[ JUMP BOOST ]-------------------------------------------------//
				
				if (c.getType() == Material.FEATHER) {
					if (player.hasPermission(jumpperm)){
					if (effetju.get(player.getUniqueId()) == Boolean.FALSE) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10000000, jumpin));
						player.sendMessage(prefix + " " + jumpmsg);
						effetju.put(player.getUniqueId(), true);
					} else {
						player.sendMessage(prefix + " " + Main.cfg.getString("effect-erreur").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§"));
					}
					}
					if (!(player.hasPermission(jumpperm))){
						player.sendMessage(prefix + " " + jumpnoperm);
					}
					e.setCancelled(true);
				}
				
				//-------------------------------------------------[ REGEN ]-------------------------------------------------//
				
				if (c.getType() == Material.GOLDEN_APPLE) {
					if (player.hasPermission(regenperm)){
						if (effetre.get(player.getUniqueId()) == Boolean.FALSE) {
							player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 10000000, regenin));
							player.sendMessage(prefix + " " + regenmsg);
							effetre.put(player.getUniqueId(), true);
						} else {
							player.sendMessage(prefix + " " + Main.cfg.getString("effect-erreur").replaceAll("(&([a-f0-9]))", "§$2").replaceAll("&", "§"));
						}
					}
					if (!(player.hasPermission(regenperm))){
						player.sendMessage(prefix + " " + regennoperm);
					}
					e.setCancelled(true);
				}
				
				//-------------------------------------------------[ GLASS ]-------------------------------------------------//
				
				if (c.getType() == Material.STAINED_GLASS_PANE) {
					e.setCancelled(true);
				}
			}

		}
	}
}
