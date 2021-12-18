package com.Bossslime.Modifier.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.Chat;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class OnJoin implements Listener{
	
	public Boolean check = true;
	public TextComponent msg = new TextComponent("null");
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		check = true;
		Player player = e.getPlayer();
		String activeModifiers = Chat.color("&eThe active modifiers are:");
		
		for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
			if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
				Main.getSettingsConfig().getConfig().set("Modules." + key, false);
				Main.getSettingsConfig().save();
				
			}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
	        	if (activeModifiers.equals(Chat.color("&eThe active modifiers are:"))) {
	        		activeModifiers = activeModifiers + Chat.color("&a " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"));
	        	}else {
	        		activeModifiers = activeModifiers + Chat.color("&f, &a" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"));
	        	}
	        	msg = new TextComponent(Chat.color(activeModifiers));
	        	msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Chat.color(Main.getLanguageConfig().getConfig().getString("Normal.HoverMessage"))).create()));
	        	msg.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/modifiers"));
	        	
			}
			
		}
		if (activeModifiers.equals(Chat.color("&eThe active modifiers are:"))) {
			if (Main.getLanguageConfig().getConfig().get("Errors.NoActiveModifiers") == null) {
				check = false;
				
			}else {
				activeModifiers = Chat.color(Main.getLanguageConfig().getConfig().getString("Errors.NoActiveModifiers"));
			}
		}
		
		if (check == true) {
			if (activeModifiers.equals(Chat.color(Main.getLanguageConfig().getConfig().getString("Errors.NoActiveModifiers")))) {
				player.sendMessage(activeModifiers);
			}else {
				player.spigot().sendMessage(msg);
				
			}
		}else {
			
		}
		
	}

}
