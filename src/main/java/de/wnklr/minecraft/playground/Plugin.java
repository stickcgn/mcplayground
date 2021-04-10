package de.wnklr.minecraft.playground;

import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("# mcplayground enabled");
        getServer().getPluginManager().registerEvents(new PlayerMovementListener(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("# mcplayground disabled");
    }
}
