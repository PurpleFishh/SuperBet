package me.purplefishh.dipcraft.superbet.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.purplefishh.dipcraft.superbet.resorce.Repleace;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class BaniInv {

	public static Inventory invBani() {
		Inventory inv = Bukkit.createInventory(null, 45, Repleace.repleace(Resorce.bet_inv_name()));
		ItemStack barieraalba = Resorce.line_bg();
		// Fundal
		for (int i = 0; i < 45; ++i)
			inv.setItem(i, barieraalba);
		int b = 100;
		for (int i = 7; i > 0; --i) {
			inv.setItem(9 + i, add(b));
			b *= 10;
		}
		b = 100;
		for (int i = 7; i > 0; --i) {
			inv.setItem(18 + i, remove(b));
			b *= 10;
		}
		
		inv.setItem(38, Resorce.put_item());
		inv.setItem(42, Resorce.cancel_item());
		return inv;
	}

	private static ItemStack add(int b) {
		ItemStack item = Resorce.increase_item();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Resorce.increase_amount_color()) + "+" + punct(b));
		item.setItemMeta(meta);
		return item;
	}

	private static ItemStack remove(int b) {
		ItemStack item = Resorce.decrease_item();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Resorce.decrease_amount_color()) + "-" + punct(b));
		item.setItemMeta(meta);
		return item;
	}

	static String punct(int b) {
		String s = "";
		while (b > 999) {
			s+= ".000";
			b/=1000;
		}
		return b + s;
	}

}
