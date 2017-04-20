package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Action;
import model.Pokemon;
import model.pokemon.Dragonair;
import model.pokemon.Dratini;
import model.pokemon.Exeggcute;
import model.pokemon.Marowak;
import model.pokemon.Mewtwo;
import model.pokemon.Paras;
import model.pokemon.Parasect;
import model.pokemon.Pinsir;
import model.pokemon.PokemonRarity;
import model.pokemon.PokemonType;
import model.pokemon.Poliwag;
import model.pokemon.Tauros;

public class testPokemon {

	Pokemon dragonair = new Dragonair();
	Pokemon dratini = new Dratini();
	Pokemon exeggcute = new Exeggcute();
	Pokemon marowak = new Marowak();
	Pokemon mewtwo = new Mewtwo();
	Pokemon paras = new Paras();
	Pokemon parasect = new Parasect();
	Pokemon pinsir = new Pinsir();
	Pokemon poliwag = new Poliwag();
	Pokemon tauros = new Tauros();
	
	@Test
	public void testMakePokemon() {
		assertEquals(PokemonType.DRAGONAIR.toString(), dragonair.getName());
		//System.out.println(PokemonType.DRAGONAIR.toString());
		assertEquals(PokemonType.DRATINI.toString(), dratini.getName());
		assertEquals(PokemonType.EXEGGCUTE.toString(), exeggcute.getName());
		assertEquals(PokemonType.MAROWAK.toString(), marowak.getName());
		assertEquals(PokemonType.MEWTWO.toString(), mewtwo.getName());
		assertEquals(PokemonType.PARAS.toString(), paras.getName());
		assertEquals(PokemonType.PARASECT.toString(), parasect.getName());
		assertEquals(PokemonType.PINSIR.toString(), pinsir.getName());
		assertEquals(PokemonType.POLIWAG.toString(), poliwag.getName());
		assertEquals(PokemonType.TAUROS.toString(), tauros.getName());
	}
	
	@Test
	public void testGetters() {
		Boolean greaterThan = dragonair.getLevel() > 24;
		Boolean lessThan    = dragonair.getLevel() < 36;
		assertTrue(greaterThan);
		assertTrue(lessThan);
		
		greaterThan = dratini.getMaxHP() > 149;
		lessThan    = dratini.getMaxHP() < 366;
		assertTrue(greaterThan);
		assertTrue(lessThan);
		
		greaterThan = mewtwo.getSpeed() > 99;
		lessThan    = mewtwo.getSpeed() < 121;
		assertTrue(greaterThan);
		assertTrue(lessThan);
		
		assertEquals(PokemonRarity.COMMON.toString(), dratini.getRarity());
		assertEquals(PokemonRarity.UNCOMMON.toString(), dragonair.getRarity());
		assertEquals(PokemonRarity.RARE.toString(), mewtwo.getRarity());
		
		assertEquals(pinsir.getMaxHP(), pinsir.getCurHP());
		assertFalse(pinsir.isKnockedOut());
		pinsir.takeDamage(5);
		assertEquals(pinsir.getMaxHP()-5, pinsir.getCurHP());
		assertFalse(pinsir.isKnockedOut());
		
		pinsir.takeDamage(10000);
		assertEquals(0, pinsir.getCurHP());
		assertTrue(pinsir.isKnockedOut());
	}
	
	@Test
	public void testFlee() {
		assertEquals(12, dratini.getFleeChance());
		assertEquals(24, dragonair.getFleeChance());
		assertEquals(36, mewtwo.getFleeChance());
		
		dratini.changeFleeChance(12);
		assertEquals(24, dratini.getFleeChance());
		
		dratini.changeFleeChance(76);
		assertEquals(100, dratini.getFleeChance());
		assertTrue(dratini.fleeCheck());
		
		dratini.changeFleeChance(-100);
		assertEquals(0, dratini.getFleeChance());
		assertFalse(dratini.fleeCheck());
	}
	
	@Test
	public void testCatch() {
		assertEquals(42, dratini.getCatchChance());
		assertEquals(21, dragonair.getCatchChance());
		assertEquals(14, mewtwo.getCatchChance());
		
		dratini.changeCatchChance(8);
		assertEquals(50, dratini.getCatchChance());
		
		dratini.changeCatchChance(50);
		assertEquals(100, dratini.getCatchChance());
		assertTrue(dratini.catchCheck());
		
		dratini.changeCatchChance(-100);
		assertEquals(0, dratini.getCatchChance());
		assertFalse(dratini.catchCheck());
	}
	
	@Test
	public void testEatingOrAction() {
		assertFalse(tauros.isEating());
		tauros.setEating(true);
		assertTrue(tauros.isEating());
		tauros.HitByRock();
		assertFalse(tauros.isEating());
		tauros.eatBait();
		assertTrue(tauros.isEating());
		assertEquals(Action.EAT, tauros.chooseAction());
		
		dratini.changeFleeChance(-12);
		assertEquals(0, dratini.getFleeChance());
		assertEquals(Action.ATTACK, dratini.chooseAction());
		dratini.changeFleeChance(100);
		assertEquals(Action.RUN_AWAY_SUCCED, dratini.chooseAction());
	}

}
