package model;

import java.util.ArrayList;

public class PokemonBelt {
	
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
	
	public Pokemon[] getBeltArray(){				// return the whole pokemon on belt, type is array of pokemon
		return (Pokemon[]) belt.toArray();
	}
	
	public int getSize(){							// return the number of pokemon on belt.
		return belt.size();
	}
	
	
}
