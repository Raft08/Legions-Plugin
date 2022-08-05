package be.raft.legions.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenusHandler implements Listener {
    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        //If legion menu
        if (event.getView().getTitle().equalsIgnoreCase("Legion Menu")) {
            //if the clicked item is air, return
            if (event.getCurrentItem() == null) return;
            //Cancel the item moving
            event.setCancelled(true);

            if (event.getCurrentItem().getType().equals(Material.CHIPPED_ANVIL)) {
                Player player = (Player) event.getWhoClicked();
            }
        }
    }
}
