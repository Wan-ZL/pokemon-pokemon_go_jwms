package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class Encounter implements Serializable{

	private static final long serialVersionUID = 1781411409588048334L;

	private Pokemon pokemon;
	private Trainer trainer;
	private ArrayList<Image> pokemonImgs;
	
	public Encounter(Pokemon pokemon, Trainer trainer) {
		this.pokemon = pokemon;
		this.trainer = trainer;
		
		String[] pokePics = pokemon.getPics();
		
		try {
			for (int i=0; i < 5; i++) {
				
			}
		} catch(Exception e) {
			
		}
	}
	
	// Returns the Pokemons name as a string
	public String getPokemonName() {
		return pokemon.getName();
	}
	
	// make a catch attempt
	public boolean isCaught() {
		boolean temp = pokemon.catchCheck();
		if (temp) {
			trainer.addPokemon(pokemon);
		}
		return temp;
	}
	
	// get the pokemons health
	public String getPokemonHP() {
		return pokemon.getCurHP() + "/" + pokemon.getMaxHP();
	}
	
	
}
