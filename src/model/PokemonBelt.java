package model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class PokemonBelt implements ListModel<String>, Serializable{
	
	private static final long serialVersionUID = -574054507504033536L;

	private ArrayList<Pokemon> belt;
	
	public PokemonBelt(){
		belt = new ArrayList<Pokemon>();
	}
	
	public boolean addPokemon(Pokemon pokemon){		// add a pokemon to belt, return true if success
		return belt.add(pokemon);
	}

	public int getSize(){							// return the number of pokemon on belt.
		return belt.size();
	}

	public void removAll() {
		belt.clear();
	}

	@Override
	public String getElementAt(int index) {
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
