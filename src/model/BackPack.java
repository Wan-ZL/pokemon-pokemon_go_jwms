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
			return true;
		} else {
			return false;
		}
	}
	
	// Discards the given amount of an item
	public void discardItem(Item item, int num) {
		
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
