package com.Bossslime.Modifier;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.Bossslime.Modifier.Commands.ModifierCommand;
import com.Bossslime.Modifier.Commands.ModifiersCommand;
import com.Bossslime.Modifier.Configs.LanguageConfig;
import com.Bossslime.Modifier.Configs.ModifierConfig;
import com.Bossslime.Modifier.Configs.SettingsConfig;
import com.Bossslime.Modifier.Listeners.InventoryStuff;
import com.Bossslime.Modifier.Listeners.OnDeath;
import com.Bossslime.Modifier.Listeners.OnJoin;
import com.Bossslime.Modifier.Listeners.ViewersUpdater;
import com.Bossslime.Modifier.Utils.Chat;

public class Main extends JavaPlugin{
	private static LanguageConfig languageConfig;
	private static SettingsConfig settingsConfig;
	private static ModifierConfig modifierConfig;
	
	@SuppressWarnings("unused")
	public void onEnable() {
		Chat.tellConsole("&7[&cModifiers&7] &aThe plugin has been successfully enabled.");
		
		//Register Commands
		this.getCommand("modifiers").setExecutor(new ModifiersCommand());
		this.getCommand("modifier").setExecutor(new ModifierCommand());
		
		//Register Events
		Bukkit.getPluginManager().registerEvents(new InventoryStuff(), this);
		Bukkit.getPluginManager().registerEvents(new OnDeath(), this);
		Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
		
		//Register Repeaters
		ViewersUpdater update = new ViewersUpdater(true);
		
		//Register Configs
		settingsConfig = new SettingsConfig("Settings.yml");
		modifierConfig = new ModifierConfig("Modifier.yml");
		
		//Register Config Values
		for (String key : modifierConfig.getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
			if (settingsConfig.getConfig().get("Modules." + key) == null) {
				settingsConfig.getConfig().set("Modules." + key, false);
			}
		}
		if (settingsConfig.getConfig().get("Language") == null) {
			settingsConfig.getConfig().set("Language", "EN-US");
			languageConfig = new LanguageConfig("Languages/EN-US.yml");
		}else {
			languageConfig = new LanguageConfig("Languages/" + settingsConfig.getConfig().getString("Language") + ".yml");
		}
		settingsConfig.save();
		
	}
	
	
	
	
	public static SettingsConfig getSettingsConfig() {
		return settingsConfig;
	}
	public static ModifierConfig getModifierConfig() {
		return modifierConfig;
	}
	public static LanguageConfig getLanguageConfig() {
		return languageConfig;
	}
	
	
	public static LanguageConfig setLanguangeConfig(String languageFile) {
		languageConfig = new LanguageConfig("Languages/" + languageFile + ".yml");
		return languageConfig;
	}

}
