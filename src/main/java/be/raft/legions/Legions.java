package be.raft.legions;

import be.raft.legions.commands.LegionCommand;
import be.raft.legions.events.MenusHandler;
import be.raft.legions.events.PlayerLifeCycle;
import be.raft.legions.events.ServerLifeCycle;
import be.raft.legions.objects.LegionsObject;
import be.raft.legions.utils.LegionUtils;
import be.raft.legions.utils.SaveManager;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Legions extends JavaPlugin {
    public static LegionsObject legions;


    private static Legions plugin;

    @Override
    public void onEnable() {

        plugin = this;

        //Start Message
        System.out.println("+------------------+");
        System.out.println("| Legions Enabled! |");
        System.out.println("+------------------+");

        //Event Register
        getServer().getPluginManager().registerEvents(new PlayerLifeCycle(), this);
        getServer().getPluginManager().registerEvents(new ServerLifeCycle(), this);
        getServer().getPluginManager().registerEvents(new MenusHandler(), this);

        //Load legions
        legions = SaveManager.loadLegions();
        assert legions != null;

        //Verify legion
        if (!LegionUtils.legionsValid(legions)) {
            System.out.println("Disabling " + plugin.getName() + " legion data is invalid/corrupted!");
            if (SaveManager.backupFileExist()) {
                System.out.println("You can try to load the legion backup, just rename 'legions.json.bak' to 'legions.json' your world folder");
            }
            System.out.println("If you are unable to fix it please try deleting file 'legions.json' in your world folder!");
            new SimplePluginManager(getServer(), new SimpleCommandMap(getServer())).disablePlugin(Legions.getPlugin());
        }

        //Backup legions
        SaveManager.backupLegionFile();

        //Commands registering
        getCommand("legion").setExecutor(new LegionCommand());
    }

    @Override
    public void onDisable() {
        //Stop Message
        System.out.println("Legions has been disabled!");


        //Save Legions
        SaveManager.saveLegions(legions);
    }

    public static Legions getPlugin() {
        return plugin;
    }
}
