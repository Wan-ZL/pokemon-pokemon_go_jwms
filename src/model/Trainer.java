package model;

import model.items.SafariBall;

public class Trainer {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	
	private static Trainer thisTrainer;
	
	public Trainer(String name) {
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
	
	public PokemonBelt getBelt(){					// return the pokemonbelt
		return belt;
	}
}
