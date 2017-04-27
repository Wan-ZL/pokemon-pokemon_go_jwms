package model;
// why do we need encounter??
public class Encounter{

	private Pokemon pokemon;
	private Trainer trainer;
	
	public Encounter(Pokemon pokemon, Trainer trainer) {
		this.pokemon = pokemon;
		this.trainer = trainer;
	}
	
	// Returns the Pokemon name as a string
	public String getPokemonName() {
		return pokemon.getName();
	}
	
	
	
	
}
