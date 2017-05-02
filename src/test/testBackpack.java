package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.BackPack;
import model.items.ItemType;
import model.items.SafariBall;

public class testBackpack {
	
	private BackPack pack;
	
	public testBackpack(){
		pack = new BackPack();
	}

	@Test
	public void test() {
		assertEquals(-1, pack.numItem(ItemType.NUGGET));
		assertEquals(true, pack.addItem(new SafariBall(6)));
		pack.discardItem(ItemType.SAFARI_BALL, 1);
		assertEquals(5, pack.numItem(ItemType.SAFARI_BALL));
		assertEquals(ItemType.SAFARI_BALL, pack.getItemAt(0).getType());
		pack.useItem(ItemType.SAFARI_BALL);
		assertEquals(true, pack.addItem(new SafariBall(70)));
		assertEquals(false, pack.addItem(new SafariBall(1)));
		assertEquals(1, pack.getBackpackArray().size());
		
		// jtable functions
		assertEquals(1, pack.getRowCount());
		assertEquals(2, pack.getColumnCount());
		assertEquals("Name", pack.getColumnName(0));
		assertEquals("Value", pack.getColumnName(1));
		assertEquals(String.class, pack.getColumnClass(0));
		assertEquals(String.class, pack.getColumnClass(1));
		assertEquals(false, pack.isCellEditable(0, 0));
		pack.getValueAt(0,1);
		pack.getValueAt(0, 0);
		
		
	}
	

}
