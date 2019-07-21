package me.purplefishh.dipcraft.superbet.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.purplefishh.dipcraft.superbet.command.BetIntemGive;
import me.purplefishh.dipcraft.superbet.event.BetEvent;
import me.purplefishh.dipcraft.superbet.event.BetOpen;
import me.purplefishh.dipcraft.superbet.resorce.ColorUtils;
import me.purplefishh.dipcraft.superbet.resorce.Repleace;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class Main extends JavaPlugin {
	static FileConfiguration cf;
	static Plugin pl = null;
	
	public static  Inventory inv;
	
	@Override
	public void onEnable() {
		System.out.println("[SuperBet] Enable!");
		configs();
		commands();
		events();
		cf = getConfig();
		pl = this;
		inv = Bukkit.createInventory(null, 45, Repleace.repleace(Resorce.main_inv_name()));
		ColorUtils.colorinv(inv);
		
	}

	@Override
	public void onDisable() {
		System.out.println("[SuperBet] Disble!");
	}
	
	public static Plugin plugin()
	{
		return pl;
	}
	
	public static FileConfiguration config()
	{
		return cf;
	}
	
	private void configs()
	{
		getConfig().addDefault("RuletaInventoryName", ChatColor.RED +""+ ChatColor.BOLD +"Ruleta");
		getConfig().addDefault("BaniInventoryName", ChatColor.GREEN +""+ ChatColor.BOLD +"Pariaza");
		getConfig().options().copyDefaults(true);
		saveConfig();
		saveDefaultConfig();
	}
	private void commands()
	{
		this.getCommand("bet").setExecutor(new BetIntemGive());
	}
	private void events()
	{
		PluginManager plmanager = Bukkit.getPluginManager();
		plmanager.registerEvents(new BetOpen(), this);
		plmanager.registerEvents(new BetEvent(), this);
	}
	

}
