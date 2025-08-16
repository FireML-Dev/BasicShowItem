package uk.firedev.basicshowitem;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BasicShowItem extends JavaPlugin {

    private final Metrics metrics = new Metrics(this, 26943);

    @Override
    public void onEnable() {
        getCommand("basicshowitem").setExecutor(new PluginCommand());
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }

}
