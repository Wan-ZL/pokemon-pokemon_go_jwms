package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Encounter implements Serializable{

	private static final long serialVersionUID = 1781411409588048334L;

	private Pokemon pokemon;
	private Trainer trainer;
	private Image[] pokemonImgs;
	
	public Encounter(Pokemon pokemon, Trainer trainer) {
		this.pokemon = pokemon;
		this.trainer = trainer;
		pokemonImgs = new Image[5];
		
		try {
			for (int i=0; i < 5; i++) {
				//System.out.println("image: " + i);
				File temp = new File(pokemon.getPic(i));
				Image temp2 = ImageIO.read(temp);
				pokemonImgs[i] = temp2;
			}
		} catch(IOException e) {
			System.out.println("Cannot find the image file.");
			e.printStackTrace();
		}
	}
	
	// get a pokemon image to draw
	public Image getPokeImg(int index) {
		return pokemonImgs[index];
	}
	
	// Returns the Pokemons name as a string
	public String getPokemonName() {
		return pokemon.getName();
	}
	
	// make a catch attempt
	public boolean isCaught() {
		boolean temp = pokemon.catchCheck();
		if (temp) {
			trainer.addPokemon(pokemon);
		}
		return temp;
	}
	
	// get the pokemons health
	public String getPokemonHP() {
		return pokemon.getCurHP() + "/" + pokemon.getMaxHP();
	}
	
	// Trainer throws a rock at the pokemon
	public void throwRock() {
		pokemon.HitByRock();
	}
	
	// Trainer throws a bait at the pokemon
	public void throwBait() {
		pokemon.eatBait();;
	}
	
	
}
