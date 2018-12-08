package com.skermishmc.core.dependencies;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class Vault {
	
	Plugin pl;
	
    private static Economy econ = null;
    private static final Logger log = Logger.getLogger("Minecraft");
	
	public Vault(Plugin pl) {
		this.pl = pl;
	}

    private boolean setupEconomy() {
        if (pl.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = pl.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    
    public static Economy getEconomy() {
        return econ;
    }
    
    public void initializeConfig() {
        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", pl.getDescription().getName()));
            pl.getServer().getPluginManager().disablePlugin(pl);
            return;
        }
    }
	
}
