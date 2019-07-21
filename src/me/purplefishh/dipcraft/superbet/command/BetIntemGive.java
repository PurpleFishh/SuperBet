package me.purplefishh.dipcraft.superbet.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.purplefishh.dipcraft.superbet.main.Main;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class BetIntemGive implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can execute this command!");
			return true;
		}
		if (sender.hasPermission("sueprbet.command.inventory")) {
			if (args.length >= 2) {
				if (args[1].equalsIgnoreCase("inventory")) {
					if (exPlayer(args[0])) {
						Player p = Bukkit.getPlayer(args[0]);
						p.openInventory(Main.inv);
					} else
						sender.sendMessage(Resorce.offline_player());
					return true;
				}
			}
		} else
			sender.sendMessage(Resorce.permission());
		if (sender.hasPermission("sueprbet.command.itemgive")) {
			Player p = (Player) sender;
			if (args.length > 0) {
				if (sender.hasPermission("sueprbet.command.itemgive.other")) {
					if (exPlayer(args[0])) {
						p = Bukkit.getPlayer(args[0]);
						sender.sendMessage(Resorce.send_item());
					} else {
						sender.sendMessage(Resorce.offline_player());
						return true;
					}
				}else
					sender.sendMessage(Resorce.permission());
			}
			p.getInventory().addItem(Resorce.BetItem());
			p.sendMessage(Resorce.get_item());
		}else
			sender.sendMessage(Resorce.permission());
		return true;
	}

	private boolean exPlayer(String name) {
		for (Player key : Bukkit.getOnlinePlayers())
			if (key.getName().equalsIgnoreCase(name))
				return true;
		return false;
	}
}
