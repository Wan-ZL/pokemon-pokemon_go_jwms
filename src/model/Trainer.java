package model;


public class Trainer {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	
	private static Trainer thisTrainer;
	
	public Trainer(String name) {
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
