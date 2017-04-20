package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

import model.items.Item;
import model.items.SafariBall;
import model.pokemon.Paras;

public class Trainer implements Serializable{
	
	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	private String trainerDirection;				// the trainer direction. Type is String
	private Point trainerPosition;					// the trainer position. Type is Point. Point initial is (0,0)
	private boolean positionChanged;
	private boolean moved;
	private int step;
	
	private int map;	// 1 means trainer in map1, 2 means trainer in map2
	
	private static Trainer thisTrainer;
	
	private Trainer(String name) {
		this.map = 1;
		this.step = 500;
		this.pack = new BackPack();
		pack.addItem(new SafariBall(30));
		this.belt = new PokemonBelt();
		this.name = name;
		this.trainerDirection = "down";
		this.trainerPosition= new Point();

		
		// initial position 
		this.trainerPosition.setLocation(15, 5);
		this.positionChanged = false;
		this.moved = false;
		//this.addPokemon(new Paras()); // For testing
		
	}
	
	public static Trainer getTrainerInstance(){		// create instance variable of trainer
		if(thisTrainer == null){
			thisTrainer = new Trainer("default name");
		}
		return thisTrainer;
	}
	
	
	public int getStep(){
		return this.step;
	}
	
	public void setPosition(int x, int y){
		this.trainerPosition.setLocation(x, y);
		step--;
	}
	// ******
	public boolean MoveChanged(){
		return this.moved;
	}
	
	public void setName(String name) {
		if (name != null){
			this.name = name;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setChangedMove(boolean status){
		this.moved = status;
	}
	
	public String getTrainerDirection(){			// return the trainer direction
		return this.trainerDirection;
	}
	
	public boolean DirectionChanged(){
		return this.positionChanged;
	}
	
	public void setChangedDirection(boolean statue){
		this.positionChanged = statue;
	}
	
	public boolean setTrainerDirection(String theDirection){		// NOTE: this function only accept String "down", "up", "left", "right". All lowerCase !!!!
		if(theDirection.equals("down") || theDirection.equals("up") || theDirection.equals("left") || theDirection.equals("right")){
			this.trainerDirection = theDirection;
			return true;
		}
		System.out.print("Function setTrainerDirection argument doesn't match");
		return false;
	}
	// **********
	
	
	public int getMapNum() {
		return map;
	}
	
	public int getX(){						// return trainer x position
		return (int) this.trainerPosition.getX();
	}
	
	public int getY(){						// return trainer y position
		return (int) this.trainerPosition.getY();

	}
	
	public boolean addPokemon(Pokemon pokemon){		// add a pokemon to belt, return true if success
		return this.belt.addPokemon(pokemon);
	}
	/*
	public boolean removePokemon(Pokemon pokemon){	// remove a pokemon from belt, if have multi same pokemon, remove the first one.
		return this.belt.removePokemon(pokemon);
	}
	
	public Pokemon removePokemon(int index){		// remove a pokemon on specific index, return the removed pokemon object.
		return this.belt.removePokemon(index);
	}
	*/
	/*
	public ArrayList<Pokemon> getBeltArray(){		// return the whole belt
		return this.belt.getBeltArray();
	}
	
	public ArrayList<Item> getBackpackArray(){		// return the whole backpack
		return this.pack.getBackpackArray();
	}
	*/
	/*
	public int getSize(){							// return the number of pokemon on belt.
		return this.belt.getSize();
	}
	*/
	public PokemonBelt getPokemonBelt(){
		return belt;
	}
	
	public BackPack getBackpack(){
		return this.pack;
	}
	/*
	public void removeAllPokemoninBelt() {
		belt.removAll();
	}
	*/
}