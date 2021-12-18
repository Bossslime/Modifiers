package com.Bossslime.Modifier.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Items {
	
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static ItemStack createItemByte(int materialId, int byteId, int amount, String displayName, String... loreString) {
		
		ItemStack item;
		List<String> lore = new ArrayList();
		
		item = new ItemStack(materialId, amount, (short) byteId);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chat.color(displayName));
		for (String s : loreString) {
			lore.add(Chat.color(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
}
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public static ItemStack createItem(int materialId, int amount, String displayName, String... loreString) {
		
		ItemStack item;
		List<String> lore =  new ArrayList();
		
		item = new ItemStack(materialId, amount);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chat.color(displayName));
		for (String s : loreString) {
			lore.add(Chat.color(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);

		return item;
	}
	@SuppressWarnings({ "deprecation" })
	public static ItemStack createItemByteNoLore(int materialId, int byteId, int amount, String displayName) {
		
		ItemStack item;
		
		item = new ItemStack(materialId, amount, (short) byteId);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chat.color(displayName));
		item.setItemMeta(meta);
		return item;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack PlayerHead(String owner, String displayName, String... loreString) {
		
		List<String> lore =  new ArrayList();
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1 , (short) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(owner);
		meta.setDisplayName(Chat.color(displayName));
		for (String s : loreString) {
			lore.add(Chat.color(s));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	@SuppressWarnings("deprecation")
	public static ItemStack createItemNoLore(int materialId, int amount, String displayName) {
		
		ItemStack item;
		
		item = new ItemStack(materialId, amount);
		
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(Chat.color(displayName));
		item.setItemMeta(meta);

		return item;
	}
	public boolean hasAvailableSlot(Player player) {
		  Inventory inv = player.getInventory();
		  return inv.firstEmpty() != -1;
		}
}
