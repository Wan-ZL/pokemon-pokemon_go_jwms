package model;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import model.items.Item;

public class PokemonBelt implements ListModel{
	
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

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return belt.get(index).getName();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}
	
	
}
