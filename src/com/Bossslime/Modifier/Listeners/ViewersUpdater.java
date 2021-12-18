package com.Bossslime.Modifier.Listeners;

import org.bukkit.craftbukkit.libs.jline.internal.Urls;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.Chat;
import com.Bossslime.Modifier.Utils.GUI;
import com.Bossslime.Modifier.Utils.Items;
import com.Bossslime.Modifier.Utils.Viewer;


public class ViewersUpdater extends Urls implements Runnable {
	 
    public final Main main = Main.getPlugin(Main.class);
 
    public ViewersUpdater(boolean start) {
    	if(start) main.getServer().getScheduler().runTaskTimerAsynchronously(main, this, 20, 5);
    }
 
    @Override
    public void run() {
    	if ((Viewer.getMemory() == null) || Viewer.getMemory().isEmpty()) return;
        for (Player player : Viewer.getMemory()) {
        	if (player.getOpenInventory().getTopInventory() == null) return;
        	if (player.getOpenInventory().getTopInventory().getTitle() == null) return;
        	if (player.getOpenInventory() == null) return;
        	if (player.getOpenInventory().getTitle() == null) return;
        	
        	if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Modifier Settings ⪼ 1"))) {
					Inventory inv = GUI.ModifierGUI(player);
						
					for (int i = 0; i < inv.getSize(); i++) {
		        		int slot = i;
		        		main.getServer().getScheduler().runTask(main, () -> {
		        			if (inv.getItem(slot) != null || inv.getItem(slot) != Items.createItemByteNoLore(160, 15, 1, "&7")) {
		        				if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Modifier Settings ⪼ 1"))) {
		        					player.getOpenInventory().getTopInventory().setItem(slot, inv.getItem(slot));
		        				}
		        			}
		        		});
        		
        		}
        	}else if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Modifiers ⪼ 1"))) {
				Inventory inv = GUI.ModifiersGUI(player);
				
				for (int i = 0; i < inv.getSize(); i++) {
	        		int slot = i;
	        		main.getServer().getScheduler().runTask(main, () -> {
	        			if (inv.getItem(slot) != null || inv.getItem(slot) != Items.createItemByteNoLore(160, 15, 1, "&7")) {
	        				if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Modifiers ⪼ 1"))) {
	        					player.getOpenInventory().getTopInventory().setItem(slot, inv.getItem(slot));
	        				}
	        			}
	        		});
				}
        		
        	}else if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Languages ⪼ 1"))) {
				Inventory inv = GUI.LanguagesGUI(player);
				
				for (int i = 0; i < inv.getSize(); i++) {
	        		int slot = i;
	        		main.getServer().getScheduler().runTask(main, () -> {
	        			if (inv.getItem(slot) != null || inv.getItem(slot) != Items.createItemByteNoLore(160, 15, 1, "&7")) {
	        				if (player.getOpenInventory().getTopInventory().getTitle().equals(Chat.color("Languages ⪼ 1"))) {
	        					player.getOpenInventory().getTopInventory().setItem(slot, inv.getItem(slot));
	        				}
	        			}
	        		});
				}
        	}
        }
 
    }
}