package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.items.Item;
import model.items.ItemType;


public class BackPack implements Serializable, TableModel{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1120322238595862779L;
	private ArrayList<Item> pack;
	private int maxItems, currAmt;
	
	public BackPack() {
		pack = new ArrayList<Item>();
		maxItems = 75;
	}
	
	// Add an item to the pack
	public boolean addItem(Item item) {
		if (hasSpace(item.getAmount())) {
			if (checkItem(item.getType())) {
				pack.get(indexOf(item.getType())).addAmount(item.getAmount());
			} else {
				pack.add(item);
			}
			currAmt += item.getAmount();
			return true;
		} else {
			return false;
		}
	}
	
	private boolean checkItem(ItemType type){
		for(int i = 0 ; i < pack.size() ; i++){
			if(pack.get(i).getType().equals(type)){
				return true;
			}
		}
		return false;
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
			if (pack.get(i).getType().equals(type)) {
				return i;
			}
		}
		return -1;
	}
	
	// returns true if the pack has space left
	private boolean hasSpace(int amt) {
		return (currAmt + amt) <= maxItems;
	}
	
	// Use an item from the pack. (remove the item from pack)
	public void useItem(ItemType type) {
		this.pack.remove(type);
	}
	
	// return the Item at index
	public Item getItemAt(int index) {
		return pack.get(index);
	}
	
	public ArrayList<Item> getBackpackArray(){
		return this.pack;
	}


	// need to implement these method for table model interface
		@Override
		public int getRowCount() {
			return pack.size();
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if(columnIndex == 0)
				return "Name";
			else
				return "Value";
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if(columnIndex <=1)
				return String.class;
			else 
				return Integer.class;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Item item = pack.get(rowIndex);
			if(columnIndex == 0)	
				return item.getType();
			else
				return item.getAmount();
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

}
