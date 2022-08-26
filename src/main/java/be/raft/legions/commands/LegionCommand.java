package be.raft.legions.commands;

import be.raft.legions.Legions;
import be.raft.legions.utils.LegionUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
                if (args[1] == null) {
                    player.sendMessage(ChatColor.RED + "Please give a legion name!");
                    player.sendMessage(ChatColor.GOLD + "Usage : " + ChatColor.YELLOW + "/legion create <legion name>");
                    return true;
                }
                create(player, args[1]);
                return true;
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

        if (!LegionUtils.hasLegion(player)) {
            player.sendMessage(ChatColor.RED + "You don't have a legion! Create new legion or join a legion");
            return;
        }

    }

    public void create(Player player, String name) {

        //Check if player has a legion
        if (LegionUtils.hasLegion(player)) {
            player.sendMessage(ChatColor.RED + "You already are in a legion!");
            return;
        }

        //Check if name hasn't special chars
        if (Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(name).find()) {
            player.sendMessage(ChatColor.RED + "You can not use special chars!");
            return;
        }

        //Check if name is allowed
        if (Legions.legions.getBlockedName().contains(name)) {
            player.sendMessage(ChatColor.RED + "You can not use this " + name + " as a legion name!");
            return;
        }

        //Create Legion
        Legions.legions.getLegions().add(LegionUtils.createLegion(name, player));

        player.sendMessage(ChatColor.GREEN + "Successfully create " + name);
    }
}
