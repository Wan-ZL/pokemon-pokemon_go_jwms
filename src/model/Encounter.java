package model;

import java.io.Serializable;

public class Encounter implements Serializable{

	private static final long serialVersionUID = 1781411409588048334L;

	private Pokemon pokemon;
	private Trainer trainer;
	
	public Encounter(Pokemon pokemon, Trainer trainer) {
		this.pokemon = pokemon;
		this.trainer = trainer;
	}
	
	public Pokemon getPokemon(){
		return this.pokemon;
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
	// need to do something for the pokemon's turn 
	// pokemon do: eat the bait, hit by the rock
	// then pokemon's action: get caught, run away, attack the trainer
	// 
	
}
