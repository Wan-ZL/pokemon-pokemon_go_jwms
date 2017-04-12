package model;

import java.util.ArrayList;

import model.items.Item;
import model.items.ItemType;

public class BackPack {

	private ArrayList<Item> pack;
	private int maxItems, currAmt;
	
	public BackPack() {
		pack = new ArrayList<Item>();
		maxItems = 50;
	}
	
	// Add an item to the pack
	public boolean addItem(Item item) {
		if (hasSpace(item.getAmount())) {
			if (pack.contains(item)) {
				pack.get(pack.indexOf(item)).addAmount(item.getAmount());
			} else {
				pack.add(item);
			}
			currAmt += item.getAmount();
			return true;
		} else {
			return false;
		}
	}
	
	// Discards the given amount of an item
	public void discardItem(ItemType type, int num) {
		if (numItem(type) > 0) {
			pack.get(indexOf(type)).addAmount(-num);
			currAmt -= num;
		}
	}
	
	// Return the amount of a specific item
	public int numItem(ItemType type) {
		if (indexOf(type) != -1) {
			return pack.get(indexOf(type)).getAmount();
		}
		return -1;
	}
	
	// Return the index of the item in the pack
	private int indexOf(ItemType type) {
		for (int i = 0; i < pack.size(); i++) {
			if (pack.get(i).getType() == type) {
				return i;
			}
		}
		return -1;
	}
	
	// returns true if the pack has space left
	private boolean hasSpace(int amt) {
		return (currAmt + amt) <= maxItems;
	}
	
	// Use an item from the pack
	public void useItem() {
		// TODO: determine what the item is and how to use it
	}
}
