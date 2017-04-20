package test;
import static org.junit.Assert.*;

import org.junit.Test;

import controller.MapCreater;
import model.Map;
public class testMap {
	Map map = new Map();
	MapCreater creater = new MapCreater();
	@Test
	public void testMap() {
		assertEquals(creater.getMap1(), map.getMap(1));
		assertEquals(creater.getMap2(), map.getMap(2));
		assertEquals(creater.getMap3(), map.getMap(3));
		assertEquals("t", map.getItemOnMap(3, 0, 0));
	}
}
