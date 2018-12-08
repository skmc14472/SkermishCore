package com.skermishmc.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.skermishmc.core.player.User;

public class OnPlayerJoinEvent implements Listener {

	Plugin pl;
	
	public OnPlayerJoinEvent(Plugin pl) {
		this.pl = pl;
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		User user = new User(e.getPlayer());
		
		
		user.initializePlayer();
		user.createPlayerConfig();
		user.createPlayerDefaults();
		user.savePlayerConfig();
		
		
		
		
		
		
		
		
	}
	
	
}
