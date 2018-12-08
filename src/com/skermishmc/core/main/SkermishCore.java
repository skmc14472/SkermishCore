package com.skermishmc.core.main;

import java.util.logging.Logger;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

<<<<<<< HEAD
import com.skermishmc.core.commands.CoreCommand;
=======
>>>>>>> 7cf3c1c58f421252e42cc5514f228af1c0792842
import com.skermishmc.core.utils.Config;

import net.milkbowl.vault.economy.Economy;

public class SkermishCore extends JavaPlugin {

	private static Economy econ = null;
	private static final Logger log = Logger.getLogger("Minecraft");
<<<<<<< HEAD
	private static Config cfg;
=======
>>>>>>> 7cf3c1c58f421252e42cc5514f228af1c0792842

	public void onEnable() {

		Config config = new Config(this);

		config.initializeConfig();
<<<<<<< HEAD
		
		setupCommands();
=======
>>>>>>> 7cf3c1c58f421252e42cc5514f228af1c0792842

		if (!setupEconomy()) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

		log.info("[SkermishCore] SkermishCore has been successfuly loaded!");

	}

	public void onDisable() {
		log.info("[SkermishCore] SkermishCore has been disabled!");

	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public static Economy getEconomy() {
		return econ;
	}
<<<<<<< HEAD
	
	private void setupCommands() {
		getCommand("core").setExecutor(new CoreCommand(cfg));
	}
	
=======

>>>>>>> 7cf3c1c58f421252e42cc5514f228af1c0792842
}
