package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Pokemon;
import model.Trainer;
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
		assertEquals("default name", t.getName());
		String name1 = "trainer1";
		t.setName(name1);
		assertEquals("trainer1", t.getName());
		
		// test in which map
		assertEquals(1,t.getMapNum());
		
		
		// test steps
		assertEquals(500,t.getStep());
		// the position
		assertEquals(15,t.getX());
		assertEquals(5,t.getY());
		
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
		t.addPokemon(p1);
		assertEquals(1, t.getPokemonBelt().getSize());
		t.addPokemon(p2);
		assertEquals(2, t.getPokemonBelt().getSize());
		t.addPokemon(p3);
		assertEquals(3, t.getPokemonBelt().getSize());
		
		
		assertEquals(30, t.getBackpack().getSize());
		//

	}
	
	
	
}
