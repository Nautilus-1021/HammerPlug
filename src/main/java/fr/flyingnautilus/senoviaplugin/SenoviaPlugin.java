package fr.flyingnautilus.senoviaplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class SenoviaPlugin extends JavaPlugin {
    
    private Logger senoviaLogger;

    @Override
    public void onEnable() {
        senoviaLogger = getLogger();
        senoviaLogger.info("Plugin démarré !");
    }

    @Override
    public void onDisable() {
        
    }

}
