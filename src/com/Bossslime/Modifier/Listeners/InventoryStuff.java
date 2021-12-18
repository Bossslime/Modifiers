package com.Bossslime.Modifier.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.Chat;
import com.Bossslime.Modifier.Utils.Items;
import com.Bossslime.Modifier.Utils.Viewer;


public class InventoryStuff implements Listener{
	public final Main main = Main.getPlugin(Main.class);
	
	@EventHandler
	public void invClose(InventoryCloseEvent event) {
		if(event.getInventory() == null) return;
		if(event.getInventory().getTitle() == null) return;
        Player player = (Player) event.getPlayer();
        String s = event.getInventory().getTitle();
        if (s.equals(Chat.color("Modifier Settings ⪼ 1"))){
        	Viewer memory = new Viewer();
			memory.removeViewer(player);
        }else if (s.equals(Chat.color("Modifiers ⪼ 1"))){
        	Viewer memory = new Viewer();
			memory.removeViewer(player);
        	
        }else if (s.equals(Chat.color("Languages ⪼ 1"))){
        	Viewer memory = new Viewer();
			memory.removeViewer(player);
        	
        }
	}
	
	@EventHandler
	public void modifierInvClick(InventoryClickEvent e) {
		if (e.getClickedInventory() == null) return;
		if (e.getClickedInventory().getTitle() == null) return;
		if (e.getClickedInventory().getTitle().equals(Chat.color("Modifier Settings ⪼ 1"))) {
			e.setCancelled(true);
			Player p = (Player) e.getWhoClicked();
			if (e.getSlot() == 49) {
				p.closeInventory();
			}else {
				for (String key : Main.getModifierConfig().getConfig().getConfigurationSection("Modifiers").getKeys(false)) {
					if (e.getCurrentItem().equals((Object) Items.createItemByte(159, 14, 1, "&cEnable/Disable " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7Click to Enable/Disable", "&7" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7", "&7Current Status: &cDisabled"))) {
						if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, false);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
							
						}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, false);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
						}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == false) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, true);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &a&lENABLED &e&l" + key));
						}
						
					}else if (e.getCurrentItem().equals((Object) Items.createItemByte(159, 5, 1, "&aEnable/Disable " + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7Click to Enable/Disable", "&7" + Main.getModifierConfig().getConfig().getString("Modifiers." + key + ".Modifier-Name"), "&7", "&7Current Status: &aEnabled"))) {
						if (Main.getSettingsConfig().getConfig().get("Modules." + key) == null) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, false);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
							
						}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == true) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, false);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &c&lDISABLED &e&l" + key));
						}else if (Main.getSettingsConfig().getConfig().getBoolean("Modules." + key) == false) {
							Main.getSettingsConfig().getConfig().set("Modules." + key, true);
							Main.getSettingsConfig().save();
							p.sendMessage(Chat.color("&e&lYou have &a&lENABLED &e&l" + key));
						}
						
					}
				}
				
				
			}
		}
		
	}
	
	
	
	@EventHandler
	public void modifiersInvClick(InventoryClickEvent e) {
		if (e.getClickedInventory() == null) return;
		if (e.getClickedInventory().getTitle() == null) return;
		if (e.getClickedInventory().getTitle().equals(Chat.color("Modifiers ⪼ 1"))) {
			e.setCancelled(true);
			if (e.getSlot() == 49) {
				e.getWhoClicked().closeInventory();
			}
		}
		
	}
	
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void languagesInvClick(InventoryClickEvent e) {
		if (e.getClickedInventory() == null) return;
		if (e.getClickedInventory().getTitle() == null) return;
		if (e.getClickedInventory().getTitle().equals(Chat.color("Languages ⪼ 1"))) {
			e.setCancelled(true);
			if (e.getCurrentItem().getTypeId() == 340) {
				String languageName = e.getCurrentItem().getItemMeta().getDisplayName().substring(2);
				if (languageName.equals(Main.getSettingsConfig().getConfig().getString("Language"))) {
					e.getWhoClicked().sendMessage(Chat.color("&ePlugin language is already set to &a" + languageName + "&e."));
					
				}else {
					Main.getSettingsConfig().getConfig().set("Language", languageName);
					Main.getSettingsConfig().save();
					Main.setLanguangeConfig(languageName);
					e.getWhoClicked().sendMessage(Chat.color("&ePlugin language has been set to &a" + languageName + "&e."));
					
				}
				
			}else if (e.getSlot() == 49) {
				e.getWhoClicked().closeInventory();
			}
			
			
		}
		
	}
	
	
	@EventHandler
	public void playerInvClick(InventoryClickEvent e) {
		if (e.getClickedInventory() == null) return;
		if (e.getClickedInventory().getTitle() == null) return;
		if (e.getClickedInventory() == e.getWhoClicked().getInventory()) {
			if (e.getWhoClicked().getOpenInventory().getTopInventory().getName().equals("Modifiers ⪼ 1")) {
				e.setCancelled(true);
				
			}else if (e.getWhoClicked().getOpenInventory().getTopInventory().getName().equals("Modifier Settings ⪼ 1")) {
				e.setCancelled(true);
				
			}else if (e.getWhoClicked().getOpenInventory().getTopInventory().getName().equals("Languages ⪼ 1")) {
				e.setCancelled(true);
				
			}
			
		}
		
	}

}
