package model.items;

public class Lure extends Item{
	public Lure(ItemType type, int value, int amt) {
		super(type, value, amt);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void useItem() {
		this.amt--;
		
	}

}
