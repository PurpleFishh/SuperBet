package me.purplefishh.dipcraft.superbet.utils;

import org.bukkit.entity.Player;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class Win {

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void winer(int win) {
		for (Player p : Resorce.pariu.keySet()) {
			if (Resorce.pariu.get(p) == win) {
				p.sendMessage(Resorce.win(Resorce.pariubani.get(p) * 2));
				Economy eco = new Economy();
				double money = 0;
				try {
					money = eco.getMoney(p.getName());
					if (win == 3)
						eco.setMoney(p.getName(), money + Resorce.pariubani.get(p) * 14);
					else
						eco.setMoney(p.getName(), money + Resorce.pariubani.get(p) * 2);
				} catch (UserDoesNotExistException e1) {
					e1.printStackTrace();
				} catch (NoLoanPermittedException e) {
					e.printStackTrace();
				}

			} else
				p.sendMessage(Resorce.lose());
		}
	}

}
