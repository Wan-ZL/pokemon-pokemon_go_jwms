package model;

import java.io.Serializable;
import java.util.ArrayList;

import java.awt.Point;

import controller.MapCreater;
import model.items.Item;
import model.items.MaxPotion;
import model.items.SafariBall;
import model.pokemon.Paras;

public class Trainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272385814256960966L;
	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	private int step; // step counter, start at 0;
	private Map theMap;
	private String trainerDirection; // the trainer direction. Type is String
	private Point trainerPosition; // the trainer position. Type is Point. Point
									// initial is (0,0)
	private boolean positionChanged;
	private boolean moved;

	private int map; // 1 means trainer in map1, 2 means trainer in map2

	private static Trainer thisTrainer;

	private Trainer(String name) {
		this.step = 0;
		this.map = 1;
		this.theMap = new Map();
		this.pack = new BackPack();
		this.belt = new PokemonBelt();
		// initialize the default items
		pack.addItem(new SafariBall(30));
		pack.addItem(new MaxPotion(20));
		
		belt.addPokemon(new Paras());
		
		this.name = name;
		this.trainerDirection = "down";
		this.trainerPosition = new Point();
		this.trainerPosition.setLocation(0, 0);
		this.positionChanged = false;
		this.moved = false;

	}

	public boolean MoveChanged() {
		return this.moved;
	}

	public void setChangedMove(boolean status) {
		this.moved = status;
	}

	public int getX() { // return trainer x position
		return (int) this.trainerPosition.getX();
	}

	public int getY() { // return trainer y position
		return (int) this.trainerPosition.getY();
	}

	public String getTrainerDirection() { // return the trainer direction
		return this.trainerDirection;
	}

	public boolean DirectionChanged() {
		return this.positionChanged;
	}

	public void setChangedDirection(boolean statue) {
		this.positionChanged = statue;
	}

	public boolean setTrainerDirection(String theDirection) { // NOTE: this
																// function only
																// accept String
																// "down", "up",
																// "left",
																// "right". All
																// lowerCase
																// !!!!
		if (theDirection.equals("down") || theDirection.equals("up") || theDirection.equals("left")
				|| theDirection.equals("right")) {
			this.trainerDirection = theDirection;
			return true;
		}
		System.out.print("Function setTrainerDirection argument doesn't match");
		return false;
	}

	public static Trainer getTrainerInstance() { // create instance variable of
													// trainer
		if (thisTrainer == null) {
			thisTrainer = new Trainer("This is default name"); 	// this is default name
		}
		return thisTrainer;
	}

	public String getName() { // return the name of trainer
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStep() { // step add one
		this.step++;
	}

	public int getStep() { // return the step counter value
		return this.step;
	}

	public boolean addPokemon(Pokemon pokemon) { // add a pokemon to belt,
													// return true if success
		return this.belt.addPokemon(pokemon);
	}

	public boolean removePokemon(Pokemon pokemon) { // remove a pokemon from
													// belt, if have multi same
													// pokemon, remove the first
													// one.
		return this.belt.removePokemon(pokemon);
	}

	public Pokemon removePokemon(int index) { // remove a pokemon on specific
												// index, return the removed
												// pokemon object.
		return this.belt.removePokemon(index);
	}

	//*
	public ArrayList<Pokemon> getBeltArray() { // return the whole belt
		return this.belt.getBeltArray();
	}

	public ArrayList<Item> getBackpackArray() { // return the whole backpack
		return this.pack.getBackpackArray();
	}
	//*
	
	public PokemonBelt getPokemonBelt(){
		return belt;
	}
	
	public BackPack getBackpack(){
		return this.pack;
	}
	
	
	
	public int getSize() { // return the number of pokemon on belt.
		return this.belt.getSize();
	}

	public String[][] getWholeMap() { // return the whole map. return a string
										// 2d array
		return this.theMap.getMap(map);
	}

	public String getItemOnMap(int i, int j) { // return the Item on map, like
												// tree or stone. return value
												// is String
		return this.theMap.getMap(map)[i][j];
	}

	public void removeAllPokemoninBelt() { // remove all pokemon in belt. (new
											// pokemonbelt)
		this.belt = new PokemonBelt();
	}

	public Pokemon getPokemon(int index) {
		return this.belt.getBeltArray().get(index);
	}

}
