package model.items;

public abstract class Item {

	private ItemType type;
	private int value;
	
	public Item(ItemType type, int value) {
		this.type = type;
		this.value = value;
	}
}
