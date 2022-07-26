package fr.flyingnautilus.hammerplugin;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HammerListener implements Listener {

    private Logger logger;

    public HammerListener(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        ItemStack hammer = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta hammerM = hammer.getItemMeta();
        hammerM.setDisplayName("§cDiamond Hammer");
        hammerM.setLore(Arrays.asList("Hammer en diamand","Casse en 3x3"));
        hammer.setItemMeta(hammerM);

        player.getInventory().addItem(hammer);
        player.updateInventory();

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        Player player = e.getPlayer();
        Block block = e.getBlock();

        if(player.getItemInHand().getType() == Material.DIAMOND_PICKAXE) {
            block.breakNaturally(player.getItemInHand());
            logger.info("X: " + block.getX() + " Y: " + block.getY() + " Z: " + block.getZ());
            World world = player.getWorld();
            if(block.getY() < player.getLocation().getY() || block.getY() >= player.getLocation().getY() + 2) {
                Location loc = new Location(world, block.getX() + 1, block.getY(), block.getZ());
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX() + 1, block.getY(), block.getZ() + 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX(), block.getY(), block.getZ() + 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX() - 1, block.getY(), block.getZ() + 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX() - 1, block.getY(), block.getZ());
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX() - 1, block.getY(), block.getZ() - 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX(), block.getY(), block.getZ() - 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
                loc = new Location(world, block.getX() + 1, block.getY(), block.getZ() - 1);
                loc.getBlock().breakNaturally(player.getItemInHand());
            } else if(block.getY() >= player.getLocation().getY() && block.getY() < player.getLocation().getY() + 2) {
                if((player.getLocation().getYaw() >= -45 && player.getLocation().getYaw() <= 45) || (player.getLocation().getYaw() >= 135 || player.getLocation().getYaw() <= -135)) {
                    Location loc = new Location(world, block.getX() + 1, block.getY(), block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX() + 1, block.getY() + 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() + 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX() - 1, block.getY() + 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX() - 1, block.getY(), block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX() - 1, block.getY() - 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() - 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX() + 1, block.getY() - 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                } else {
                    Location loc = new Location(world, block.getX(), block.getY() + 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() + 1, block.getZ() + 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY(), block.getZ() + 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() - 1, block.getZ() + 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() - 1, block.getZ());
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() - 1, block.getZ() - 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY(), block.getZ() - 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                    loc = new Location(world, block.getX(), block.getY() + 1, block.getZ() - 1);
                    loc.getBlock().breakNaturally(player.getItemInHand());
                }
            }
        } else {
            block.breakNaturally(player.getItemInHand());
        }
    }

}
