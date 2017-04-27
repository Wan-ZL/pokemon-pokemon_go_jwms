package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.PokemonBelt;

public class testPokemonBelt {

	@Test
	public void testGettersSetters() {
		PokemonBelt pb = new PokemonBelt();
		pb.removAll();
		assertEquals(0, pb.getBeltArray().size());
		assertEquals(0, pb.getSize());
	}

}
