package me.purplefishh.dipcraft.superbet.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

import me.purplefishh.dipcraft.superbet.main.Main;
import me.purplefishh.dipcraft.superbet.resorce.Repleace;
import me.purplefishh.dipcraft.superbet.resorce.Resorce;
import me.purplefishh.dipcraft.superbet.utils.TimeUntilStart;

public class BetEvent implements Listener {

	@EventHandler
	public void PutMoneyEvent(InventoryClickEvent e) {
		if (e.getView().getTitle().equals(Repleace.repleace(Resorce.bet_inv_name()))) {
			if (e.getCurrentItem() != null && e.getCurrentItem().getType() != Material.AIR) {
				if (e.getCurrentItem().equals(Resorce.main_bg()) || e.getCurrentItem().equals(Resorce.line_bg()))
					e.setCancelled(true);
				if (e.getCurrentItem().equals(Resorce.put_item())) {
					if (!Resorce.pariubani.containsKey(e.getWhoClicked())
							|| Resorce.pariubani.get(e.getWhoClicked()) == 0) {
						Resorce.pariubani.remove(e.getWhoClicked());
						Resorce.pariu.remove(e.getWhoClicked());
						e.getWhoClicked().sendMessage(Resorce.no_money_bet());

					} else {
						if (TimeUntilStart.start == false)
							TimeUntilStart.start();
						removemoney((Player) e.getWhoClicked(), Resorce.pariubani.get(e.getWhoClicked()));
						e.getWhoClicked().openInventory(Main.inv);
					}

					e.setCancelled(true);
				}
				if (e.getCurrentItem().equals(Resorce.cancel_item())) {
					e.getWhoClicked().openInventory(Main.inv);
					Resorce.pariubani.remove(e.getWhoClicked());
					Resorce.pariu.remove(e.getWhoClicked());
					e.setCancelled(true);
				}
				Player p = (Player) e.getWhoClicked();
				int bani = money(e.getSlot());
				if (Resorce.pariubani.keySet().contains(p) == false)
					Resorce.pariubani.put(p, 0);
				int sumapariu = Resorce.pariubani.get(p);
				if (e.getSlot() >= 10 && e.getSlot() <= 16) {
					sumapariu += bani;
					if (sumapariu > getmoney(p))
						sumapariu = (int) getmoney(p);
					p.sendMessage(Resorce.money_select(sumapariu));
				}
				if (e.getSlot() >= 19 && e.getSlot() <= 25) {
					if (sumapariu == 0) {
						p.sendMessage(Resorce.make_less_zero());
						return;
					}
					sumapariu -= bani;
					if (sumapariu < 0)
						sumapariu = 0;
					p.sendMessage(Resorce.no_money_bet());
				}

				Resorce.pariubani.replace(p, sumapariu);
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void exit(InventoryCloseEvent e) {
		if (e.getView().getTitle().equals(Repleace.repleace(Resorce.bet_inv_name()))) {
			if (Resorce.pariubani.containsKey(e.getPlayer()) && Resorce.pariubani.get(e.getPlayer()) == 0) {
				Resorce.pariu.remove(e.getPlayer());
				Resorce.pariubani.remove(e.getPlayer());
				
			}
		}
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public double getmoney(Player p) {
		Economy eco = new Economy();
		double money = 0;
		try {
			money = eco.getMoney(p.getName());
		} catch (UserDoesNotExistException e1) {
			e1.printStackTrace();
		}
		return money;
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public void removemoney(Player p, int sum) {
		Economy eco = new Economy();
		double money = (int) getmoney(p);
		try {
			eco.setMoney(p.getName(), money - sum);
		} catch (UserDoesNotExistException e1) {
			e1.printStackTrace();
		} catch (NoLoanPermittedException e) {
			e.printStackTrace();
		}
	}

	int money(int p) {
		switch (p) {
		case 10:
			return 100000000;
		case 11:
			return 10000000;
		case 12:
			return 1000000;
		case 13:
			return 100000;
		case 14:
			return 10000;
		case 15:
			return 1000;
		case 16:
			return 100;
		case 19:
			return 100000000;
		case 20:
			return 10000000;
		case 21:
			return 1000000;
		case 22:
			return 100000;
		case 23:
			return 10000;
		case 24:
			return 1000;
		case 25:
			return 100;

		}
		return 0;
	}
}
