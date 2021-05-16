package fr.ouwox.ccore.Listener;

import fr.ouwox.ccore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class AtoutDisable implements Listener {

	@EventHandler
	public void cmd2(PlayerQuitEvent e) {
		String speedperm = Main.cfg.getString("speed.perm");
		String forceperm = Main.cfg.getString("force.perm");
		String fireperm = Main.cfg.getString("fire.perm");
		String jumpperm = Main.cfg.getString("jumpboost.perm");
		String regenperm = Main.cfg.getString("regeneration.perm");
		Player p = e.getPlayer();
		if (p.hasPermission(speedperm) || p.hasPermission(forceperm) || p.hasPermission(fireperm) || p.hasPermission(jumpperm) || p.hasPermission(regenperm)) {
			if (p.hasPotionEffect(PotionEffectType.SPEED) || p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) || p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE) || p.hasPotionEffect(PotionEffectType.JUMP) || p.hasPotionEffect(PotionEffectType.REGENERATION)) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.JUMP);
				p.removePotionEffect(PotionEffectType.REGENERATION);
				AtoutsEffect.effets.put(p.getUniqueId(), false);
				AtoutsEffect.effetf.put(p.getUniqueId(), false);
				AtoutsEffect.effetfi.put(p.getUniqueId(), false);
				AtoutsEffect.effetre.put(p.getUniqueId(), false);
				AtoutsEffect.effetju.put(p.getUniqueId(), false);
			}

		}
	}

	@EventHandler
	public void cmd3(PlayerJoinEvent e) {

		String speedperm = Main.cfg.getString("speed.perm");
		String forceperm = Main.cfg.getString("force.perm");
		String fireperm = Main.cfg.getString("fire.perm");
		String jumpperm = Main.cfg.getString("jumpboost.perm");
		String regenperm = Main.cfg.getString("regeneration.perm");
		Player p = e.getPlayer();
		AtoutsEffect.effets.put(p.getUniqueId(), false);
		AtoutsEffect.effetf.put(p.getUniqueId(), false);
		AtoutsEffect.effetfi.put(p.getUniqueId(), false);
		AtoutsEffect.effetre.put(p.getUniqueId(), false);
		AtoutsEffect.effetju.put(p.getUniqueId(), false);
		if (p.hasPermission(speedperm) || p.hasPermission(forceperm) || p.hasPermission(fireperm) || p.hasPermission(jumpperm) || p.hasPermission(regenperm)) {
			if (p.hasPotionEffect(PotionEffectType.SPEED) || p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) || p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE) || p.hasPotionEffect(PotionEffectType.JUMP) || p.hasPotionEffect(PotionEffectType.REGENERATION)) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.JUMP);
				p.removePotionEffect(PotionEffectType.REGENERATION);
				AtoutsEffect.effets.put(p.getUniqueId(), false);
				AtoutsEffect.effetf.put(p.getUniqueId(), false);
				AtoutsEffect.effetfi.put(p.getUniqueId(), false);
				AtoutsEffect.effetre.put(p.getUniqueId(), false);
				AtoutsEffect.effetju.put(p.getUniqueId(), false);
			}

		}
	}

	@EventHandler
	public void PlayerDeath(PlayerDeathEvent e){
		String speedperm = Main.cfg.getString("speed.perm");
		String forceperm = Main.cfg.getString("force.perm");
		String fireperm = Main.cfg.getString("fire.perm");
		String jumpperm = Main.cfg.getString("jumpboost.perm");
		String regenperm = Main.cfg.getString("regeneration.perm");
		Player p = e.getEntity();
		if (p.hasPermission(speedperm) || p.hasPermission(forceperm) || p.hasPermission(fireperm) || p.hasPermission(jumpperm) || p.hasPermission(regenperm)) {
			if (p.hasPotionEffect(PotionEffectType.SPEED) || p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE) || p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE) || p.hasPotionEffect(PotionEffectType.JUMP) || p.hasPotionEffect(PotionEffectType.REGENERATION)) {
				p.removePotionEffect(PotionEffectType.SPEED);
				p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.JUMP);
				p.removePotionEffect(PotionEffectType.REGENERATION);
				AtoutsEffect.effets.put(p.getUniqueId(), false);
				AtoutsEffect.effetf.put(p.getUniqueId(), false);
				AtoutsEffect.effetfi.put(p.getUniqueId(), false);
				AtoutsEffect.effetre.put(p.getUniqueId(), false);
				AtoutsEffect.effetju.put(p.getUniqueId(), false);
			}

		}

	}
	
}
