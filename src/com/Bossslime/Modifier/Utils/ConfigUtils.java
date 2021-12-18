package com.Bossslime.Modifier.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.Bossslime.Modifier.Main;

public class ConfigUtils {
public final Main main = Main.getPlugin(Main.class);

    private String fileName;

    private File file;
    private FileConfiguration fileConfiguration;


    //Class call Method
    public ConfigUtils(String fileName) {
        this.fileName = fileName;
        file = new File(main.getDataFolder(), fileName);
        fileConfiguration = new YamlConfiguration();

        this.setup();

        try {
            fileConfiguration.load(this.file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /*
     * Returns the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /*
     * Returns the file
     */
    public File getFile() {
        return this.file;
    }

    /*
     * Sets the fileName
     */
    @SuppressWarnings("unused")
	private void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /*
     * Setup the Config file if it isn't exist
     */
    public void setup() {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            main.saveResource(this.fileName, false);
        }
    }

    /*
     * Returns the fileConfiguration so you can do changes
     */
    public FileConfiguration getConfig() {
        return this.fileConfiguration;
    }

    /*
     * Saves the Config file
     */
    public void save() {
        try {
            fileConfiguration.save(this.file);
        } catch (IOException e) {
            System.out.println(this.fileName + " not found !");
        }
    }

    /*
     * Reloads the Config File
     */
    public void reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
    }


}
