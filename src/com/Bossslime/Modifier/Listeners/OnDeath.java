package com.Bossslime.Modifier.Listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.Bossslime.Modifier.Main;


public class OnDeath implements Listener{

	public final Main main = Main.getPlugin(Main.class);
	
	@EventHandler
	public void onKill(PlayerDeathEvent e) {
		LivingEntity entity = e.getEntity();
		if(entity.getType() != EntityType.PLAYER) return;
		for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
			if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
				Main.getSettingsConfig().getConfig().set("Modules." + key, false);
				Main.getSettingsConfig().save();
				
			}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
				Player player = (Player) entity;
		        Player killer = player.getKiller();
		        if (Main.getModifierConfig().getConfig().get("Modifiers." + key + ".Effects.Enabled") == null) {
		        	
		        }else if (Main.getModifierConfig().getConfig().getBoolean("Modifiers." + key + ".Effects.Enabled") == true) {
		        	if (Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Chance") == 1) {
		        		int time = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Effect-Time") * 20;
				        String effect = Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Effects.Potion-Effect");
				        int level = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Potion-Level") - 1;
				        
				        killer.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
		        	}else {
		        		Random rand = new Random();
		        		int num = rand.nextInt(Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Chance"));
		    	        num = num + 1;
		    	        int toPick = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Commands.Chance") / 2;
		    	        
		    	        if (num == toPick) {
		    	        	int time = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Effect-Time") * 20;
					        String effect = Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Effects.Potion-Effect");
					        int level = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Effects.Potion-Level") - 1;
					        
					        killer.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effect), time, level));
					        
		    	        }
		        	}
		        	
		        	
		        }
		        
		        if (Main.getModifierConfig().getConfig().get("Modifiers." + key + ".Commands.Enabled") == null) {
		        	
		        }else if (Main.getModifierConfig().getConfig().getBoolean("Modifiers." + key + ".Commands.Enabled") == true) {
		        	if (Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Commands.Chance") == 1) {
		        		for (String cmd : Main.getModifierConfig().getConfig().getStringList("Modifiers." + key + ".Commands.Run-Command")) {
	    	        		if (cmd.contains("%Player%")) {
		    	        		String killerString = killer.getName();
		    	        		cmd = cmd
				        				.replace("%Player%", killerString);
		    	        	}
	    	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
	    	        	}
		        		
		        	}else {
		        		Random rand = new Random();
		        		int num = rand.nextInt(Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Commands.Chance"));
		    	        num = num + 1;
		    	        int toPick = Main.getModifierConfig().getConfig().getInt("Modifiers." + key + ".Commands.Chance") / 2;
		    	        
		    	        if (num == toPick) {
		    	        	
		    	        	for (String cmd : Main.getModifierConfig().getConfig().getStringList("Modifiers." + key + ".Commands.Run-Command")) {
		    	        		if (cmd.contains("%Player%")) {
			    	        		String killerString = killer.getName();
			    	        		cmd = cmd
					        				.replace("%Player%", killerString);
			    	        	}
		    	        		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
		    	        	}
					        
		    	        }
		        	}
		        	
		        	
		        }
		        
		        
				
			}
			
		}
		
	}
}
