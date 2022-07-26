package fr.flyingnautilus.hammerplugin;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class HammerPlugin extends JavaPlugin {
    
    private Logger hammerLogger;

    @Override
    public void onEnable() {
        hammerLogger = getLogger();
        hammerLogger.info("Plugin démarré !");
        getServer().getPluginManager().registerEvents(new HammerListener(hammerLogger), this);
    }

    @Override
    public void onDisable() {
        
    }

}
