package com.Bossslime.Modifier.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.Bossslime.Modifier.Main;

public class GUI {
	public static int invNumber = 1;
	public static Main main = Main.getPlugin(Main.class);

	public static Inventory ModifierGUI(InventoryHolder owner) {
		int size = 6*9;
		Player player = (Player) owner;
		Viewer memory = new Viewer();
		memory.addViewer(player);
		invNumber = 1;
		Inventory inv = Bukkit.createInventory(owner, size, Chat.color("Modifier Settings ⪼ 1"));
		for(int i=0; i < size; i++) {
			  switch(i) {
			    case 10:
			    case 11:
			    case 12:
			    case 13:
			    case 14:
			    case 15:
			    case 16:
			    case 19:
			    case 20:
			    case 21:
			    case 22:
			    case 23:
			    case 24:
			    case 25:
			    case 28:
			    case 29:
			    case 30:
			    case 31:
			    case 32:
			    case 33:
			    case 34:
			    case 37:
			    case 38:
			    case 39:
			    case 40:
			    case 41:
			    case 42:
			    case 43:
			    continue;
			  }
			  

			  if(i == 49) {
			    inv.setItem(i, Items.createItem(166, 1, "&cClose", "&7Close the GUI"));
			    continue;
			    }
			    inv.setItem(i, Items.createItemByteNoLore(160, 15, 1, "&7"));
			  }
		
		for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
			if (invNumber >= 2) return inv;
			if (inv.firstEmpty() == -1) {
				inv.setItem(53, Items.createItem(262, 1, "&cNext Page", "&cComing Soon..."));
				invNumber = 2;
				
			}else {
				
				if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
					Main.getSettingsConfig().getConfig().set("Modules." + key, false);
					int nextOpen = inv.firstEmpty();
					inv.setItem(nextOpen, Items.createItemByte(159, 14, 1, "&cEnable/Disable " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7Click to Enable/Disable", "&7" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7", "&7Current Status: &cDisabled"));
					
				}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
					int nextOpen = inv.firstEmpty();
					inv.setItem(nextOpen, Items.createItemByte(159, 5, 1, "&aEnable/Disable " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7Click to Enable/Disable", "&7" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7", "&7Current Status: &aEnabled"));
					
				}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == false) {
					int nextOpen = inv.firstEmpty();
					inv.setItem(nextOpen, Items.createItemByte(159, 14, 1, "&cEnable/Disable " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7Click to Enable/Disable", "&7" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7", "&7Current Status: &cDisabled"));
					
			}
			}
			
			
			
		}
			  return inv;
			}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Inventory ModifiersGUI(InventoryHolder owner) {
		int size = 6*9;
		Player player = (Player) owner;
		Viewer memory = new Viewer();
		memory.addViewer(player);
		invNumber = 1;
		Inventory inv = Bukkit.createInventory(owner, size, Chat.color("Modifiers ⪼ 1"));
		for(int i=0; i < size; i++) {
			  switch(i) {
			    case 10:
			    case 11:
			    case 12:
			    case 13:
			    case 14:
			    case 15:
			    case 16:
			    case 19:
			    case 20:
			    case 21:
			    case 22:
			    case 23:
			    case 24:
			    case 25:
			    case 28:
			    case 29:
			    case 30:
			    case 31:
			    case 32:
			    case 33:
			    case 34:
			    case 37:
			    case 38:
			    case 39:
			    case 40:
			    case 41:
			    case 42:
			    case 43:
			    continue;
			  }
			  

			  if(i == 49) {
			    inv.setItem(i, Items.createItem(166, 1, "&cClose", "&7Close the GUI"));
			    continue;
			    }
			    inv.setItem(i, Items.createItemByteNoLore(160, 15, 1, "&7"));
			  }
		
		for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
			if (invNumber >= 2) return inv;
			if (inv.firstEmpty() == -1) {
				inv.setItem(53, Items.createItem(262, 1, "&cNext Page", "&cComing Soon..."));
				invNumber = 2;
				
			}else {
				
				if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
					Main.getSettingsConfig().getConfig().set("Modules." + key, false);
					int nextOpen = inv.firstEmpty();
					ItemStack item = Items.createItemByteNoLore(159, 14, 1, "&c" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"));
					List<String> lore =  new ArrayList();
					ItemMeta meta = item.getItemMeta();
					for (String s : Main.getModifierConfig().getConfig().getStringList("Modifiers." + key + ".Modifier-Description")) {
						lore.add(Chat.color(s));
					}
					lore.add(Chat.color("&7 "));
					lore.add(Chat.color("&7Current Status: &cDisabled"));
					meta.setLore(lore);
					item.setItemMeta(meta);
					
					inv.setItem(nextOpen, item);
					
				}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
					int nextOpen = inv.firstEmpty();
					ItemStack item = Items.createItemByteNoLore(159, 5, 1,"&a" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"));
					List<String> lore =  new ArrayList();
					ItemMeta meta = item.getItemMeta();
					for (String s : Main.getModifierConfig().getConfig().getStringList("Modifiers." + key + ".Modifier-Description")) {
						lore.add(Chat.color(s));
					}
					lore.add(Chat.color("&7 "));
					lore.add(Chat.color("&7Current Status: &aEnabled"));
					meta.setLore(lore);
					item.setItemMeta(meta);
					
					inv.setItem(nextOpen, item);
					
				}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == false) {
					int nextOpen = inv.firstEmpty();
					ItemStack item = Items.createItemByteNoLore(159, 14, 1, "&c" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"));
					List<String> lore =  new ArrayList();
					ItemMeta meta = item.getItemMeta();
					for (String s : Main.getModifierConfig().getConfig().getStringList("Modifiers." + key + ".Modifier-Description")) {
						lore.add(Chat.color(s));
					}
					lore.add(Chat.color("&7 "));
					lore.add(Chat.color("&7Current Status: &cDisabled"));
					meta.setLore(lore);
					item.setItemMeta(meta);
					
					inv.setItem(nextOpen, item);
					
				}
			}
			
			
			
		}
			  return inv;
	}
	
	
	public static Inventory LanguagesGUI(InventoryHolder owner) {
		int size = 6*9;
		Player player = (Player) owner;
		Viewer memory = new Viewer();
		memory.addViewer(player);
		invNumber = 1;
		Inventory inv = Bukkit.createInventory(owner, size, Chat.color("Languages ⪼ 1"));
		for(int i=0; i < size; i++) {
			  switch(i) {
			    case 10:
			    case 11:
			    case 12:
			    case 13:
			    case 14:
			    case 15:
			    case 16:
			    case 19:
			    case 20:
			    case 21:
			    case 22:
			    case 23:
			    case 24:
			    case 25:
			    case 28:
			    case 29:
			    case 30:
			    case 31:
			    case 32:
			    case 33:
			    case 34:
			    case 37:
			    case 38:
			    case 39:
			    case 40:
			    case 41:
			    case 42:
			    case 43:
			    continue;
			  }
			  

			  if(i == 49) {
			    inv.setItem(i, Items.createItem(166, 1, "&cClose", "&7Close the GUI"));
			    continue;
			    }
			    inv.setItem(i, Items.createItemByteNoLore(160, 15, 1, "&7"));
			  }
		
		
		File folder = new File("plugins/" + main.getName() + "/Languages");
		
		
		
		for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory() == false) {
	        	if (invNumber >= 2) return inv;
				if (inv.firstEmpty() == -1) {
					inv.setItem(53, Items.createItem(262, 1, "&cNext Page", "&cComing Soon..."));
					invNumber = 2;
					
				}else {
					String fileName = FilenameUtils.removeExtension(fileEntry.getName());
					if (fileName.equals(Main.getSettingsConfig().getConfig().getString("Language"))) {
						
						inv.setItem(inv.firstEmpty(), Items.createItem(340, 1, "&c" + fileName, "&7" + fileName + "'s Language File", "&7 ", "&cCurrently Selected"));
					}else {
						inv.setItem(inv.firstEmpty(), Items.createItem(340, 1, "&c" + fileName, "&7" + fileName + "'s Language File", "&7 ", "&aClick to Select"));
					}
					
					
				}
	        	
	        }
		}
		
		
		return inv;
	}
	
}