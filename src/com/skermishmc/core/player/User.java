package com.skermishmc.core.player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.skermishmc.core.dependencies.Vault;

import net.milkbowl.vault.economy.Economy;

public class User {

	Plugin pl;
	
	final UUID uuid;
	Player player; 
	OfflinePlayer offlinePlayer;
	Economy economy = Vault.getEconomy();
	File data;
	FileConfiguration config;
	
	public User (Player player) {
	
		this.uuid = player.getUniqueId();
		this.player = player;
		this.offlinePlayer = Bukkit.getOfflinePlayer(player.getUniqueId());
		
		
	}
	
	//NORMAL PLAYER METHODS
	
	public Player getPlayer() {
		return player;
	}
	
	public UUID getUUID() {
		return uuid;
	}
	
	public OfflinePlayer getOfflinePlayer() {
		return offlinePlayer;
	}
	
	
	//CURRENCY 
	
	public double getMoney() {
		return economy.getBalance(offlinePlayer);
	}
	
	public void addMoney(double moneyAmount) {
		economy.depositPlayer(offlinePlayer, moneyAmount);
	}
	
	public void removeMoney(double moneyAmount) {
		economy.withdrawPlayer(offlinePlayer, moneyAmount);
	}
	
	//CONFIG METHODS



	public void initializePlayer() {

		data = new File("plugins/SkermishCore/Players/" + uuid + ".yml");
		config = YamlConfiguration.loadConfiguration(data);

	}

	public void createPlayerConfig() {
		
		try {
			data.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void createPlayerDefaults() {
		if (data.length() <= 0) {
			//TODO:
			//Change "Rank" with whatever per player values we need to store.
			config.set("Rank", "default");
		} else {

		}
	}
	
    public void savePlayerConfig() {
    	if (getPlayerConfig() == null) {
    		
    	}
        try {
            getPlayerConfig().save(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public FileConfiguration getPlayerConfig() {
    	return config;
    }
    
    
//    public void setGems(double amount) {
//    	config.set("Gems", amount);
//    	savePlayerConfig();
//    }
//    
//    public void addGems(double amount) {
//    	config.set("Gems", getGems() + amount);
//    	savePlayerConfig();
//    }
//    
//    public void removeGems(double amount) {
//    	config.set("Gems", getGems() - amount);
//    	savePlayerConfig();
//    }
	
	
	
	
}
