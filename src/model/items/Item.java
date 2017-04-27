package model.items;

import java.io.Serializable;

public abstract class Item implements Serializable{

	private static final long serialVersionUID = 2794282350305690429L;
	
	protected ItemType type;
	protected int value;
	protected int amt;
	
	public Item(ItemType type, int value, int amt) {
		this.type = type;
		this.value = value;
		this.amt = amt;
	}
	
	// returns the item type
	public ItemType getType() {
		return type;
	}
	
	// return the amount of the item
	public int getAmount() {
		return amt;
	}
	
	// Add to the current amount
	public void addAmount(int num) {
		amt += num;
	}
	
	// returns the item value
	public int getValue() {
		return value;
	}
	
	// uses the item
	public abstract void useItem();
}
