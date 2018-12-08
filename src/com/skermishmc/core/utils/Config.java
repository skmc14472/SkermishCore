package com.skermishmc.core.utils;

import org.bukkit.plugin.Plugin;

public class Config {

	Plugin pl;

	public Config(Plugin pl) {

		this.pl = pl;

	}

	public void initializeConfig() {

		pl.getConfig().options().copyDefaults(true);
		pl.saveDefaultConfig();

	}

	public void reloadConfig() {

		pl.reloadConfig();

	}
	
	

}
