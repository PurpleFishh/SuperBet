package me.purplefishh.dipcraft.superbet.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.purplefishh.dipcraft.superbet.main.Main;
import me.purplefishh.dipcraft.superbet.resorce.Repleace;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;
import me.purplefishh.dipcraft.superbet.utils.BaniInv;
import me.purplefishh.dipcraft.superbet.utils.Rotire;

public class BetOpen implements Listener {

	@EventHandler
	void OpenInvBET(PlayerInteractEvent e) {
		if (e.getItem() != null && e.getItem().getType() != Material.AIR)
			if (e.getItem().equals(Resorce.BetItem())) {
				e.getPlayer().openInventory(Main.inv);
			}

	}

	@SuppressWarnings("deprecation")
	@EventHandler
	void Rot(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(Repleace.repleace(Resorce.main_inv_name()))) {
			if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
				if (e.getCurrentItem().equals(Resorce.main_bg()) || e.getCurrentItem().equals(Resorce.line_bg()))
					e.setCancelled(true);
				if (e.getCurrentItem().equals(Resorce.back()))
					e.getWhoClicked().closeInventory();
				if (e.getCurrentItem().equals(Resorce.red_button()) || e.getCurrentItem().equals(Resorce.black_button())
						|| e.getCurrentItem().equals(Resorce.green_button())) {
					if (Rotire.start == true) {
						e.getWhoClicked().sendMessage(Resorce.started_game());
					} else {
						Resorce.pariu.put((Player) e.getWhoClicked(), code(e.getCurrentItem().getData().getData()));
						e.getWhoClicked().openInventory(BaniInv.invBani());
					}
				}
				e.setCancelled(true);
			}
		}
	}

	int code(int data) {
		switch (data) {
		case 15:
			return 1;
		case 14:
			return 2;
		case 5:
			return 3;
		}
		return -1;
	}
}
