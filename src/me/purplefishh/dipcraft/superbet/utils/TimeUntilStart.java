package me.purplefishh.dipcraft.superbet.utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.purplefishh.dipcraft.superbet.main.Main;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;

public class TimeUntilStart {

	public static boolean start = false;

	public static void start() {
		start = true;
		new BukkitRunnable() {
			int t = Resorce.time();

			@Override
			public void run() {
				if (t == 0) {
					msgsend(Resorce.start());
					Rotire.InvRotire(Main.inv);
					this.cancel();
				}
				if (t % 10 == 0 && t > 0)
					msgsend(Resorce.start_in_time(t) );
				if (t < 10 && t > 0)
					msgsend(Resorce.start_in_time(t) );
				t--;
			}
		}.runTaskTimer(Main.plugin(), 20L, 20L);
	}

	public static void msgsend(String s) {
		for (Player p : Resorce.pariu.keySet()) {
			p.sendMessage(s);
		}
	}
}
