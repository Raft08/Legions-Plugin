package be.raft.legions.events;


import be.raft.legions.Legions;
import be.raft.legions.utils.SaveManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

public class ServerLifeCycle implements Listener {
    @EventHandler
    public static void onWorldSaving(WorldSaveEvent event) {
        //Backup old data
        SaveManager.backupLegionFile();

        //Save new data
        SaveManager.saveLegions(Legions.legions);
    }
}
