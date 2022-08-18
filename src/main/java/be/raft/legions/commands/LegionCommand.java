package be.raft.legions.commands;

import be.raft.legions.Legions;
import be.raft.legions.utils.LegionUtils;
import be.raft.legions.utils.PersistentDataKeys;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LegionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.GREEN + "Type '/legion help' for help");
                return true;
            }

            if (args[0].equals("help")) {
                help(sender);
                return true;
            }

            if (args[0].equals("menu")) {
                menu(player);
                return true;
            }

            if (args[0].equals("create")) {
                create(player, args[1]);
            }

            sender.sendMessage(ChatColor.GREEN + "Type '/legion help' for help");
            return true;
        }
        sender.sendMessage("This command can only be executed by a player");
        return true;
    }

    private void help(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "+----------------------<Legions>---------------------+");
        sender.sendMessage(ChatColor.GREEN + "| /legion create <name> - Create a new legion");
        sender.sendMessage(ChatColor.GREEN + "| /legion leave - Leave your legion");
        sender.sendMessage(ChatColor.GREEN + "| /legion invite <player> - Invite a player in your legion");
        sender.sendMessage(ChatColor.GREEN + "| /legion menu - Open the legion menu");
        if (sender.isOp()) {
            sender.sendMessage(ChatColor.GREEN + "|------------------------<OP>------------------------+");
            sender.sendMessage(ChatColor.GREEN + "| /legion admin delete <legion> - Delete a legion");
            sender.sendMessage(ChatColor.GREEN + "| /legion admin kick <player> <legion> - Kick a player his legion");
            sender.sendMessage(ChatColor.GREEN + "| /legion admin add <player> <legion> - Add a player to a legion");
            sender.sendMessage(ChatColor.GREEN + "| /legion admin menu <legion> - Open the admin menu of a legion");
            sender.sendMessage(ChatColor.GREEN + "| /legion admin blockname <add|list|remove> <name>");
            sender.sendMessage(ChatColor.GREEN + "| - Add or remove a name from the blocked legion names");
        }
        sender.sendMessage(ChatColor.GREEN + "+---------------------------------------------------+");
    }

    private void menu(Player player) {
        //Create inventory menu
        Inventory mainMenu = Bukkit.createInventory(player, 27, "Legion Menu");

        //Legion Setting item
        ItemStack settings = new ItemStack(Material.REDSTONE);
        ItemMeta settingsMeta = settings.getItemMeta();
        settingsMeta.setDisplayName(ChatColor.RED + "Legion Settings");
        ArrayList<String> settingsTooltip = new ArrayList<>();
        settingsTooltip.add(ChatColor.GRAY + "Click to modify settings");
        settingsMeta.setLore(settingsTooltip);
        settings.setItemMeta(settingsMeta);
        mainMenu.setItem(0, settings);

        //Legion rank item
        ItemStack ranks = new ItemStack(Material.NETHER_STAR);
        ItemMeta ranksMeta = ranks.getItemMeta();
        ranksMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Ranks");
        ArrayList<String> ranksTooltip = new ArrayList<>();
        ranksTooltip.add(ChatColor.GRAY + "Click to modify ranks");
        ranksMeta.setLore(ranksTooltip);
        ranks.setItemMeta(ranksMeta);
        mainMenu.setItem(18, ranks);

        //Legion info
        ItemStack legionInfo = new ItemStack(Material.RED_BANNER);
        ItemMeta legionInfoMeta = legionInfo.getItemMeta();
        legionInfoMeta.setDisplayName(ChatColor.GREEN + "legion.name");
        ArrayList<String> legionInfoTooltip = new ArrayList<>();
        legionInfoTooltip.add(ChatColor.GRAY + "Click to modify legion option");
        legionInfoMeta.setLore(legionInfoTooltip);
        legionInfo.setItemMeta(legionInfoMeta);
        mainMenu.setItem(13, legionInfo);

        player.openInventory(mainMenu);

    }

    public void create(Player player, String name) {
        //Check if user has give a name
        if (name == null) {
            player.sendMessage(ChatColor.RED + "Please give a legion name!");
            return;
        }

        //Check if player has a legion
        if (LegionUtils.hasLegion(player)) {
            player.sendMessage(ChatColor.RED + "You already are in a legion!");
            return;
        }

        //Check if name is allowed
        if (Legions.legions.getBlockedName().contains(name)) {
            player.sendMessage(ChatColor.RED + "You can not use this " + name + " as a legion name!");
            return;
        }

        //Create Legion
    }
}
