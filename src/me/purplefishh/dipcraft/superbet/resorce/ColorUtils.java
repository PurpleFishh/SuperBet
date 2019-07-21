package me.purplefishh.dipcraft.superbet.resorce;

import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.purplefishh.dipcraft.superbet.main.Main;

public class ColorUtils {

	FileConfiguration config = Main.config();

	public static int colorgive() {
		// 1 = negru
		// 2 = rosu
		// 3 = verde
		int color = -1, ma = 100;
		Random rand = new Random();
		int ra = rand.nextInt(ma);
		if (ra <= 45)
			color = 1;
		if (ra >= 55)
			color = 2;
		if (ra > 45 && ra < 55)
			color = 3;
		return color;
	}

	public static void colorinv(Inventory inv) {
		// Get Butoane
		ItemStack barieranegru = Resorce.line_bg();
		ItemStack barieraalba = Resorce.main_bg();
		// Fundal
		for (int i = 0; i < 9; ++i)
			inv.setItem(i, barieraalba);
		for (int i = 18; i < 45; ++i)
			inv.setItem(i, barieraalba);

		for (int i = 9; i < 18; ++i) {
			inv.setItem(i, barieranegru);

		}
		
		// Creare butoane
		
		ItemStack rosu = Resorce.red_button();
		ItemStack verde = Resorce.green_button();
		ItemStack negru = Resorce.black_button();
		

		// Indicatoare
		inv.setItem(0 * 9 + 5 - 1, barieranegru);
		inv.setItem(2 * 9 + 5 - 1, barieranegru);

		// Set Butoane
		inv.setItem(4 * 9 + 3 - 1, rosu);
		inv.setItem(4 * 9 + 5 - 1, verde);
		inv.setItem(4 * 9 + 7 - 1, negru);

		// Exit Buton
		ItemStack exit = Resorce.back();
		inv.setItem(44, exit);
	}

}
