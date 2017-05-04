package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Pokemon;
import model.Trainer;
import model.items.ItemType;
import model.items.MaxPotion;
import model.pokemon.Dragonair;
import model.pokemon.Dratini;
import model.pokemon.Exeggcute;

public class testTrainer {
	
	
	@Test
	public void testTrainer(){
		
		// test the inital status
		Pokemon p1 = new Dragonair();
		Pokemon p2 = new Dratini();
		Pokemon p3 = new Exeggcute();
		
		// test name 
		
		Trainer t = Trainer.getTrainerInstance();
		assertEquals("Ash", t.getName());
		String name1 = "trainer1";
		t.setName(name1);
		assertEquals("trainer1", t.getName());
		
		// test in which map
		assertEquals(1,t.getMapNum());
		
		
		// test steps
		assertEquals(500,t.getStep());
		// the position
		assertEquals(15,t.getX());
		assertEquals(6,t.getY());
		
		t.setPosition(15, 6);
		assertEquals(15,t.getX());
		assertEquals(6,t.getY());
		
		t.setPosition(16, 6);
		assertEquals(16,t.getX());
		assertEquals(6,t.getY());
		
		// test direction 
		assertEquals("down", t.getTrainerDirection());
		// test set direction 
		t.setTrainerDirection("up");
		assertEquals("up", t.getTrainerDirection());
		t.setTrainerDirection("right");
		assertEquals("right", t.getTrainerDirection());
		t.setTrainerDirection("left");
		assertEquals("left", t.getTrainerDirection());
		
		assertFalse(t.setTrainerDirection("nop"));
		
		assertFalse(t.DirectionChanged());
		t.setChangedDirection(true);
		assertTrue(t.DirectionChanged());
		
		// test move changed
		assertFalse(t.MoveChanged());
		t.setChangedMove(true);
		assertTrue(t.MoveChanged());
		
		// test add and remove pokemon
		t.getPokemonBelt().removAll();
		t.addPokemon(p1);
		assertEquals(1, t.getPokemonBelt().getSize());
		assertEquals(1,t.getSize());
		t.addPokemon(p2);
		assertEquals(2, t.getPokemonBelt().getSize());
		t.addPokemon(p3);
		assertEquals(3, t.getPokemonBelt().getSize());
		
		
		assertEquals(50, t.getBackpack().getSize());
		
		assertEquals(1000, t.getCurrHP());
		t.takeDamage(100);
		assertEquals(900, t.getCurrHP());
		assertFalse(t.isInBattle());
		t.heal();
		assertEquals(1000, t.getCurrHP());
		t.meetPokemon();
		assertEquals(1, t.getMapNum());
		t.setMapNum(2);
		assertEquals(2, t.getMapNum());
		int amt = t.getSize();
		t.addItem(new MaxPotion(10));
		assertEquals(3, t.getSize()); // num of Item object in the arrat list
		

	}
	
	
	
}
