package fr.ouwox.ccore.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener{
	@EventHandler
	public void JoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String moi = "Cat4clysme";
		if (p.getName().contains(moi)) {
				p.sendMessage("§2§lcAtout §aSalut §e" + moi + " §ale serveur utilise §ccAtout §aversion §c1.0 §7(§2SPIGOT§7)");
		}else return;
	}
}
