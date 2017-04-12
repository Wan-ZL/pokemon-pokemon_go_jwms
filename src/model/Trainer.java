package model;

public class Trainer {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	
	public Trainer(String name) {
		this.pack = new BackPack();
		this.name = name;
	}
}
