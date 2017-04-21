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
}
