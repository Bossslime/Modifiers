package com.Bossslime.Modifier.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.Chat;
import com.Bossslime.Modifier.Utils.GUI;

public class ModifierCommand implements CommandExecutor{
	public final Main main = Main.getPlugin(Main.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String prefix = Main.getLanguageConfig().getConfig().getString("Normal.Prefix");
		if (sender instanceof Player) {
			if (sender.hasPermission("modifier.command")) {
				if (args.length < 1) {
					for (String message : Main.getLanguageConfig().getConfig().getStringList("Normal.HelpMessage")) {
						sender.sendMessage(Chat.color(message));
					}
				}else if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("toggle")) {
						if (sender.hasPermission("modifier.command.toggle")) {
							if (args.length == 2) {
								for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
									if (key.equalsIgnoreCase(args[1])) {
										if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
											Main.getSettingsConfig().getConfig().set("Modules." + key, false);
											sender.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
											
										}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
											Main.getSettingsConfig().getConfig().set("Modules." + key, false);
											sender.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
											
										}else {
											Main.getSettingsConfig().getConfig().set("Modules." + key, true);
											sender.sendMessage(Chat.color("&e&lYou have &a&lENABLED &e&l" + key));
											
										}
										return false;
									}
									
								}
								sender.sendMessage(Chat.color("&eThe modifier \"&c" + args[1] + "&e\" doesn't exist."));
								
							}else {
								Player p = (Player) sender;
								p.openInventory(GUI.ModifierGUI(p));
								
							}
							
						}else {
							sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NoPerms")));
						}
						
					}else if (args[0].equalsIgnoreCase("reload")) {
						if (sender.hasPermission("modifier.command.reload")) {
							Main.getLanguageConfig().reload();
							Main.getModifierConfig().reload();
							Main.getSettingsConfig().reload();
							for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
								if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
									Main.getSettingsConfig().getConfig().set("Modules." + key, false);
								}
								Main.getSettingsConfig().save();
							}
							sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Normal.ReloadMessage")));
						}else {
							sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NoPerms")));
						}
						
						
						
					}else if (args[0].equalsIgnoreCase("languages")) {
						if (sender.hasPermission("modifier.command.languages")) {
							Player p = (Player) sender;
							p.openInventory(GUI.LanguagesGUI(p));
							
							
						}else {
							sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NoPerms")));
						}
						
						
						
					}else {
						for (String message : Main.getLanguageConfig().getConfig().getStringList("Normal.HelpMessage")) {
							sender.sendMessage(Chat.color(message));
						}
					}
					
					
				}else {
					for (String message : Main.getLanguageConfig().getConfig().getStringList("Normal.HelpMessage")) {
						sender.sendMessage(Chat.color(message));
					}
				}
				
				
			}else {
				sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NoPerms")));
			}
			
			
		}else {
			Chat.tellConsole(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NotHuman"));
		}
		return false;
	}

}
