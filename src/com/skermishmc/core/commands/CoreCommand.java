package com.skermishmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.skermishmc.core.utils.Config;
import com.skermishmc.core.utils.Message;

public class CoreCommand implements CommandExecutor {
	
	Config cfg;
	
	public CoreCommand(Config config) {
		this.cfg = config;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("core")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command is only executable by players.");
				return true;
			}
			
			Player player = (Player) sender;
			
			if (player.hasPermission("skermishcore.staff")) {
				if (args.length == 0) {
					player.sendMessage(Message.base);
					player.sendMessage(Message.color("&bDev&f, &cAdmin&f, &3Sr. Mod&f, &c&5Mod&f, &aJr. Mod"));
					player.sendMessage(Message.spacer);
					player.sendMessage(Message.color("&b/core reloadconfig - Reloads the plugin configuration."));
					player.sendMessage(Message.base);
					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reloadconfig")) {
						cfg.reloadConfig();
						
						player.sendMessage(Message.color("&aThe configuration was successfully reloaded."));
						return true;
					} else {
						player.sendMessage(Message.base);
						player.sendMessage(Message.color("&bDev&f, &cAdmin&f, &3Sr. Mod&f, &c&5Mod&f, &aJr. Mod"));
						player.sendMessage(Message.spacer);
						player.sendMessage(Message.color("&b/core reloadconfig - Reloads the plugin configuration."));
						player.sendMessage(Message.base);
						return true;
					}
				} else {
					player.sendMessage(Message.base);
					player.sendMessage(Message.color("&bDev&f, &cAdmin&f, &3Sr. Mod&f, &c&5Mod&f, &aJr. Mod"));
					player.sendMessage(Message.spacer);
					player.sendMessage(Message.color("&b/core reloadconfig - Reloads the plugin configuration."));
					player.sendMessage(Message.base);
					return true;
				}
			} else {
				player.sendMessage(Message.color("&cYou don't have access to this command."));
			}
		}
		
		return false;
	}

}
