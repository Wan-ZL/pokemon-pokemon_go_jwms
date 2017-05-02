package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Encounter;
import model.Pokemon;
import model.Trainer;
import model.pokemon.Paras;
import model.pokemon.Pikachu;

public class testEncounter {

	private Trainer t = Trainer.getTrainerInstance();
	
	@Test
	public void testSetup() {
		Pokemon p = new Pikachu();
		Encounter e = new Encounter(p, t);
		assertNotEquals(null, e.getPokeImg(0));
		assertNotEquals(null, e.getPokeImg(1));
		assertNotEquals(null, e.getPokeImg(2));
		assertNotEquals(null, e.getPokeImg(3));
		assertNotEquals(null, e.getPokeImg(4));
		
		assertEquals("Pikachu", e.getPokemonName());
		assertEquals(p.getCurHP() + "/" + p.getMaxHP(), e.getPokemonHP());
	}
	
	@Test
	public void testRockAndBait() {
		Pokemon p = new Paras();
		Encounter e = new Encounter(p, t);
		
		String hp = p.getCurHP() + "/" + p.getMaxHP();
		assertEquals(hp, e.getPokemonHP());
		e.throwBait();
		assertEquals(hp, e.getPokemonHP());
		e.throwRock();
		assertNotEquals(hp, e.getPokemonHP());
		String hp2 = p.getCurHP() + "/" + p.getMaxHP();
		assertEquals(hp2, e.getPokemonHP());
	}

}
