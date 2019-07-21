package me.purplefishh.dipcraft.superbet.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.purplefishh.dipcraft.superbet.main.Main;
import me.purplefishh.dipcraft.superbet.resorce.ColorUtils;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class Rotire {

	static long t;
	static List<Integer> v = new ArrayList<>();
	public static boolean start = false;
	static int rotiri() {
		Random rand = new Random();
		int ra = rand.nextInt(17);

		while (ra < 12)
			ra = rand.nextInt(17);
		return ra;
	}

	public static void InvRotire(Inventory inv) {
		start = true;
		TimeUntilStart.start = false;
		for (int i = 0; i <= 8; ++i) {
			int color = ColorUtils.colorgive();
			v.add(i, color);
			inv.setItem(9 + i, it(v.get(i)));
		}
		t = 10L;
		new BukkitRunnable() {
			int rot = rotiri();
			int n = 0;

			@Override
			public void run() {
				if (n / 2 == rot) {
					Win.winer(v.get(5));
					start = false;
					this.cancel();
				}

				for (int i = 0; i < 8; ++i)
					v.set(i, v.get(i + 1));
				v.set(8, ColorUtils.colorgive());
				n++;
				for (int i = 0; i <= 8; ++i) {
					inv.setItem(9 + i, it(v.get(i)));
				}
				t = t + (long) n * 10;

			}
		}.runTaskTimer(Main.plugin(), 20L, t);

	}

	static ItemStack it(int r) {
		switch (r) {
		case 1:
			return Resorce.Negru();

		case 2:
			return Resorce.Rosu();

		case 3:
			return Resorce.Verde();

		}
		return null;
	}
}
