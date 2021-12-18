package com.Bossslime.Modifier.Configs;

import com.Bossslime.Modifier.Main;
import com.Bossslime.Modifier.Utils.ConfigUtils;

public class ModifierConfig extends ConfigUtils {
public final Main main = Main.getPlugin(Main.class);

	public ModifierConfig(String fileName) {
		super(fileName);
		}

}
