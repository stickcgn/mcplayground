package de.wnklr.minecraft.playground;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Zuest holen wir uns ein paar Informationen:

        // Hier wird der Spieler geholt, der sich grade bewegt hat
        Player player = event.getPlayer();

        // Von dem Spieler holen wir uns seine Welt
        World world = player.getWorld();

        // Wo befindet sich der Spieler?
        Location location = player.getLocation();

        // Hier holen wir uns den Block unter dem Spieler
        Block block = location.getBlock().getRelative(BlockFace.DOWN);

        // Und jetzt machen wir was:

        // Wenn dieser Block Wasser ist...
        if (block.getType() == Material.WATER){
            // ... dann explodiert es, HIHI
            world.createExplosion(location, 5);
        }
    }
}
