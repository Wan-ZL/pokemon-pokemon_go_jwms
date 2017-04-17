package model;

import java.io.Serializable;
import java.util.ArrayList;


import model.items.Item;

public class PokemonBelt {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6433488251728986157L;
	private ArrayList<Pokemon> belt;
	
	public PokemonBelt(){
		belt = new ArrayList<Pokemon>();
	}
	
	public boolean addPokemon(Pokemon pokemon){		// add a pokemon to belt, return true if success
		return belt.add(pokemon);
	}
	
	public boolean removePokemon(Pokemon pokemon){	// remove a pokemon from belt, if have multi same pokemon, remove the first one.
		return belt.remove(pokemon);
	}
	
	public Pokemon removePokemon(int index){		// remove a pokemon on specific index, return the removed pokemon object.
		return belt.remove(index);
	}
	
	public ArrayList<Pokemon> getBeltArray(){				// return the whole pokemon on belt, type is array of pokemon
		return this.belt;
	}
	
	public int getSize(){							// return the number of pokemon on belt.
		return belt.size();
	}
	
	
}
