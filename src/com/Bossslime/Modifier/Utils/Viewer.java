package com.Bossslime.Modifier.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class Viewer {
	
	private final static List<Player> memory = new ArrayList<Player>();
	
	
    public void addViewer(Player viewer) {
        if (memory.contains(viewer) == false) {
        	memory.add(viewer);
        }
    }
    
    public void removeViewer(Player viewer) {
    	if (memory.contains(viewer) == true) {
    		memory.remove(viewer);
    	}
    }
    
    public static List<Player> getMemory() {
    	  return memory;
    }
}
