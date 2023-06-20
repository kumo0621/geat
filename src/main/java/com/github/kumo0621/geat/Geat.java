package com.github.kumo0621.geat;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Geat extends JavaPlugin implements org.bukkit.event.Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    FileConfiguration config;

    @EventHandler
    public void clickJoin(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        int level = player.getLevel();
        int x = config.getInt("coordinates." + 1 + ".x");
        int y = config.getInt("coordinates." + 1 + ".y");
        int z = config.getInt("coordinates." + 1 + ".z");
        if (event.getRightClicked().getScoreboardTags().contains("1")&&level==1) {
            Location targetLocation = new Location(player.getWorld(),x,y,z); // B地点の座標を指定
            player.teleport(targetLocation);

        }
    }
}
