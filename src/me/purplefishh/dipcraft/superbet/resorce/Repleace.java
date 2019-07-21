package me.purplefishh.dipcraft.superbet.resorce;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class Repleace {

	public static String repleace(String key)
	{
		key = ChatColor.translateAlternateColorCodes('&', key);
		return key;
	}
	public static String repleace(String key, Player p)
	{
		key = ChatColor.translateAlternateColorCodes('&', key);
		key = key.replaceAll("%player%", p.getName());
		return key;
	}
	public static String repleace(String key, Server sv)
	{
		key = ChatColor.translateAlternateColorCodes('&', key);
		key = key.replaceAll("%server%", sv.getName());
		return key;
	}
	public static String repleace(String key,Player p, Server sv)
	{
		key = ChatColor.translateAlternateColorCodes('&', key);
		key = key.replaceAll("%server%", Bukkit.getServer().getName());
		key = key.replaceAll("%player%", p.getName());
		return key;
	}
}
