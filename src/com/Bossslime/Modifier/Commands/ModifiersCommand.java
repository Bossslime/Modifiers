package com.Bossslime.Modifier.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.Chat;
import com.Bossslime.Modifier.Utils.GUI;

public class ModifiersCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String prefix = Main.getLanguageConfig().getConfig().getString("Normal.Prefix");
		if (sender instanceof Player) {
			if (sender.hasPermission("modifier.command.modifiers")) {
				Player p = (Player) sender;
				p.openInventory(GUI.ModifiersGUI(p));
				
			}else {
				sender.sendMessage(Chat.color(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NoPerms")));
				
			}
			
		}else {
			Chat.tellConsole(prefix + Main.getLanguageConfig().getConfig().getString("Errors.NotHuman"));
			
		}
		return false;
	}

}
