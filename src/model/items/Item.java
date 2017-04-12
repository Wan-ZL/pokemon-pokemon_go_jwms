package model.items;

public abstract class Item {

	private ItemType type;
	private int value;
	
	public Item(ItemType type, int value) {
		this.type = type;
		this.value = value;
	}
	
	// returns the item type
	public ItemType getType() {
		return type;
	}
	
	// returns the item value
	public int getValue() {
		return value;
	}
	
	// uses the item
	public abstract void useItem();
}
