package me.purplefishh.dipcraft.superbet.resorce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.purplefishh.dipcraft.superbet.main.Main;

public class Resorce {

	// Lista Pariu
	public static HashMap<Player, Integer> pariubani = new HashMap<>();
	public static HashMap<Player, Integer> pariu = new HashMap<>();

	// Config
	static private FileConfiguration config() {
		return Main.config();
	}

	// Messages
	public static String color(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	public static String wmput(String s) {
		return water_mark() + " " + s;
	}

	public static String water_mark() {
		return color(config().getString("water_mark"));
	}
	
	public static String permission() {
		return wmput(color(config().getString("permission")));
	}

	public static String offline_player() {
		return wmput(color(config().getString("offline_player")));
	}

	public static String send_item() {
		return wmput(color(config().getString("send_item")));
	}

	public static String get_item() {
		return wmput(color(config().getString("get_item")));
	}

	public static String started_game() {
		return wmput(color(config().getString("started_game")));
	}

	public static String main_inv_name() {
		return color(config().getString("main_inv_name"));
	}

	public static String bet_inv_name() {
		return color(config().getString("bet_inv_name"));
	}

	public static String increase_amount_color() {
		return config().getString("increase_amount_color");
	}

	public static String decrease_amount_color() {
		return config().getString("decrease_amount_color");
	}

	public static String no_money_bet() {
		return wmput(color(config().getString("no_money_bet")));
	}

	public static String money_select(int amount) {
		return wmput(color(config().getString("money_select")).replaceAll("%sum%", amount + ""));
	}

	public static String make_less_zero() {
		return wmput(color(config().getString("make_less_zero")));
	}

	public static String win(int amount) {
		return wmput(color(config().getString("win")).replaceAll("%sum%", amount + ""));
	}

	public static String lose() {
		return wmput(color(config().getString("lose")));
	}

	public static String start_in_time(int time) {
		return wmput(color(config().getString("start_in_time")).replaceAll("%time%", time + ""));
	}

	public static String start() {
		return wmput(color(config().getString("start")));
	}
	public static int time() {
		return config().getInt("time");
	}

	// Items

	public static ItemStack item_create(String id, String name, List<String> lore) {
		if (name != null)
			name = color(name);
		List<String> lorelist = new ArrayList<>();
		if (lore != null)
			for (String key : lore)
				lorelist.add(color(key));
		ItemStack item = new ItemStack(Material.getMaterial(id), 1);
		ItemMeta meta = item.getItemMeta();
		if (name != null)
			meta.setDisplayName(name);
		if (lore != null)
			meta.setLore(lorelist);
		item.setItemMeta(meta);
		return item;
	}

	@SuppressWarnings("unchecked")
	public static ItemStack BetItem() {
		String name = config().getString("betting-item-name");
		List<String> lorelist = (List<String>) config().getList("betting-item-name");
		String id = config().getString("betting-item-id");

		return item_create(id, name, lorelist);
	}

	public static ItemStack main_bg() {
		String id = config().getString("main_bg_id");
		String name = " ";
		return item_create(id, name, null);
	}

	public static ItemStack line_bg() {
		String id = config().getString("line_bg_id");
		String name = " ";
		return item_create(id, name, null);
	}


	public static ItemStack Rosu() {
		String id = config().getString("red_id");
		String name = config().getString("red_name");
		return item_create(id, name, null);
	}

	public static ItemStack Negru() {
		String id = config().getString("black_id");
		String name = config().getString("black_name");
		return item_create(id, name, null);
	}

	public static ItemStack Verde() {
		String id = config().getString("green_id");
		String name = config().getString("green_name");
		return item_create(id, name, null);
	}

	public static ItemStack back() {
		String id = config().getString("exit_id");
		String exit_name = config().getString("exit_name");
		return item_create(id, exit_name, null);
	}

	public static ItemStack red_button() {
		String id = config().getString("red_id");
		@SuppressWarnings("unchecked")
		List<String> lorelist = (List<String>) config().getList("red_button_lore");
		String name = config().getString("red_button_name");
		return item_create(id, name, lorelist);
	}

	public static ItemStack green_button() {
		String id = config().getString("green_id");
		@SuppressWarnings("unchecked")
		List<String> lorelist = (List<String>) config().getList("green_button_lore");
		String name = config().getString("green_button_name");
		return item_create(id, name, lorelist);
	}

	public static ItemStack black_button() {
		String id = config().getString("black_id");
		@SuppressWarnings("unchecked")
		List<String> lorelist = (List<String>) config().getList("black_button_lore");
		String name = config().getString("black_button_name");
		return item_create(id, name, lorelist);
	}

	public static ItemStack increase_item() {
		String id = config().getString("increase_id");
		return item_create(id, null, null);
	}

	public static ItemStack decrease_item() {
		String id = config().getString("decrease_id");
		return item_create(id, null, null);
	}

	public static ItemStack put_item() {
		String id = config().getString("put_id");
		String name = config().getString("put_name");
		return item_create(id, name, null);
	}

	public static ItemStack cancel_item() {
		String id = config().getString("cancel_id");
		String name = config().getString("cance_name");
		return item_create(id, name, null);
	}

}
