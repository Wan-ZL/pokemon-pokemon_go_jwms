package model;

import model.items.SafariBall;

public class Trainer {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	
	private static Trainer thisTrainer;
	
	private Trainer(String name) {
		this.pack = new BackPack();
		pack.addItem(new SafariBall(30));
		this.name = name;
	}
	
	public static Trainer getTrainerInstance(){		// create instance variable of trainer
		if(thisTrainer == null){
			thisTrainer = new Trainer("Trainer Name");
		}
		return thisTrainer;
	}
	
	public PokemonBelt getBelt(){					// return the pokemonbelt
		return belt;
	}
	
	public boolean addPokemon(Pokemon pokemon){		// add a pokemon to belt, return true if success
		return this.belt.addPokemon(pokemon);
	}
	
	public boolean removePokemon(Pokemon pokemon){	// remove a pokemon from belt, if have multi same pokemon, remove the first one.
		return this.belt.removePokemon(pokemon);
	}
	
	public Pokemon removePokemon(int index){		// remove a pokemon on specific index, return the removed pokemon object.
		return this.belt.removePokemon(index);
	}
	
	public Pokemon[] getBeltArray(){				// return the whole pokemon on belt, type is array of pokemon
		return this.belt.getBeltArray();
	}
	
	public int getSize(){							// return the number of pokemon on belt.
		return this.belt.getSize();
	}
}
