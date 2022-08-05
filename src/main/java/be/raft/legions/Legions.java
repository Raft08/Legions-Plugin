package be.raft.legions;

import be.raft.legions.commands.LegionCommand;
import be.raft.legions.events.MenusHandler;
import be.raft.legions.events.PlayerLifeCycle;
import be.raft.legions.events.ServerLifeCycle;
import be.raft.legions.objects.LegionsObject;
import be.raft.legions.utils.SaveManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Legions extends JavaPlugin {
    public static LegionsObject legions;

    @Override
    public void onEnable() {
        //Start Message
        System.out.println("~------------------~");
        System.out.println("| Legions Enabled! |");
        System.out.println("~------------------~");

        //Event Register
        getServer().getPluginManager().registerEvents(new PlayerLifeCycle(), this);
        getServer().getPluginManager().registerEvents(new ServerLifeCycle(), this);
        getServer().getPluginManager().registerEvents(new MenusHandler(), this);

        //Load legions
        legions = SaveManager.loadLegions();

        //Backup legion file
        SaveManager.createBackupLegions(legions);

        //Commands registering
        getCommand("legion").setExecutor(new LegionCommand());
    }

    @Override
    public void onDisable() {
        //Stop Message
        System.out.println("Legions has been disabled!");

        //Backup old legions
        SaveManager.backupLegionFile();

        //Save Legions
        SaveManager.saveLegions(legions);
    }
}
