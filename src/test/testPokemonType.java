package test; 

import static org.junit.Assert.*; 
import org.junit.Test; 
import model.Pokemon; 
import model.Trainer; 
import model.pokemon.Dragonair; 

public class testPokemonType { 

	private Trainer trainer; 
	private Dragonair d; 

	public testPokemonType(){ 
		d = new Dragonair(); 
		trainer = Trainer.getTrainerInstance(); 
		//trainer.removeAllPokemoninBelt(); 
		trainer.addPokemon(d); 
	} 
	

	@Test 
	public void TestPokemonGetName(){ 
		//assertEquals("Dragonair", this.trainer.getPokemon(0).getName()); 
	} 

	
	/*@Test 
	public void TestgetSize(){ 
		//System.out.print(this.trainer.getSize());
		assertEquals(1, this.trainer.getSize()); 
	} 
	*/
}