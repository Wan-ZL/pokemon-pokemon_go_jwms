package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.items.SafariBall;

public class Trainer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272385814256960966L;
	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	private int step;								// step counter, start at 0;
	
	private static Trainer thisTrainer;
	
	private Trainer(String name) {
		this.step = 0;
		this.pack = new BackPack();
		this.belt = new PokemonBelt();
		pack.addItem(new SafariBall(30));
		this.name = name;
	}
	
	public static Trainer getTrainerInstance(){		// create instance variable of trainer
		if(thisTrainer == null){
			thisTrainer = new Trainer("Trainer Name");
		}
		return thisTrainer;
	}
	
	public String getName(){						// return the name of trainer
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void addStep(){							// step add one
		this.step++;
	}
	
	public int getStep(){							// return the step counter value
		return this.step;
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
	
	public void removeAllPokemoninBelt(){			// remove all pokemon in belt. (new pokemonbelt)
		this.belt = new PokemonBelt();
	}
	
	public ArrayList<Pokemon> getBeltArray(){				// return the whole pokemon on belt, type is array of pokemon
		return this.belt.getBeltArray();
	}
	
	public int getSize(){							// return the number of pokemon on belt.
		return this.belt.getSize();
	}
	
	public Pokemon getPokemon(int index){
		return this.belt.getBeltArray().get(index);
	}
	
	
	
	
	
}
