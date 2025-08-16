package uk.firedev.basicshowitem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicShowItem extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("basicshowitem").setExecutor(new PluginCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }

}
