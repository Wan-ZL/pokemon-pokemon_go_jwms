package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import model.items.Item;
import model.items.ItemType;
import model.items.MaxPotion;
import model.items.SafariBall;
import model.pokemon.Dragonair;
import model.pokemon.Dratini;
import model.pokemon.Exeggcute;
import model.pokemon.Marowak;
import model.pokemon.Mewtwo;
import model.pokemon.Paras;
import model.pokemon.Primeape;
import model.pokemon.Pinsir;
import model.pokemon.Pikachu;
import model.pokemon.Tauros;

public class Trainer implements Serializable {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	private String trainerDirection; // the trainer direction. Type is String
	private Point trainerPosition; // the trainer position. Type is Point. Point
									// initial is (0,0)
	private boolean positionChanged;
	private boolean moved;
	private int step;
	private int hp;
	private int damage;

	private int mapIndex; // 1 means trainer in map1, 2 means trainer in map2
	private Map map; // the map
	private boolean isInBattle;

	private static Trainer thisTrainer;

	private Trainer(String name) {
		isInBattle = false;
		this.map = new Map();
		this.mapIndex = 1;
		this.step = 500;
		this.hp = 1000;
		this.damage = 0;
		this.pack = new BackPack();
		pack.addItem(new SafariBall(30));
		pack.addItem(new MaxPotion(20));
		this.belt = new PokemonBelt();
		this.name = name;
		this.trainerDirection = "down";
		this.trainerPosition = new Point();

		// initial position
		this.trainerPosition.setLocation(15, 6);
		this.positionChanged = false;
		this.moved = false;
		// this.addPokemon(new Paras()); // For testing

	}

	public static Trainer getTrainerInstance() { // create instance variable of
													// trainer
		if (thisTrainer == null) {
			thisTrainer = new Trainer("Ash");
		}
		return thisTrainer;
	}

	public int getStep() {
		return this.step;
	}

	public void setPosition(int x, int y) {
		this.trainerPosition.setLocation(x, y);
		step--;
	}
	
	public boolean addItem(Item item){
		return this.pack.addItem(item);
	}

	// ******
	public boolean MoveChanged() {
		return this.moved;
	}

	@SuppressWarnings("null")
	public void setName(String name) {
		//System.out.println("name: " + name + ".");
		if (name.compareTo("") != 0) {
			this.name = name;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setChangedMove(boolean status) {
		this.moved = status;
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
	// **********

	public int getMapNum() {
		return mapIndex;
	}

	public void setMapNum(int mapNum) {
		this.mapIndex = mapNum;
	}
	
	public void heal(){
		this.damage = 0;
		useItem(ItemType.MAX_POTION);
	}

	public int getX() { // return trainer x position
		return (int) this.trainerPosition.getX();
	}

	public int getY() { // return trainer y position
		return (int) this.trainerPosition.getY();

	}

	// get the trainers max hp
	public int getMaxHP() {
		return hp;
	}

	// get the trainers current hp
	public int getCurrHP() {
		return hp - damage;
	}

	// take damage
	public void takeDamage(int damage) {
		this.damage += damage;
		if(this.damage >= hp){
			this.damage = hp;
		}
	}

	public boolean addPokemon(Pokemon pokemon) { // add a pokemon to belt,
													// return true if success
		this.isInBattle = false;
		return this.belt.addPokemon(pokemon);
	}

	public void outOfBattle() { // call this function when battle end
		this.isInBattle = false;
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

	public ArrayList<Pokemon> getBeltArray() { // return the whole belt
		return this.belt.getBeltArray();
	}

	public ArrayList<Item> getBackpackArray() { // return the whole backpack
		return this.pack.getBackpackArray();
	}

	public int getSize() { // return the number of pokemon on belt.
		return this.belt.getSize();
	}

	public PokemonBelt getPokemonBelt() {
		return belt;
	}

	public void useItem(ItemType type) {
		this.pack.useItem(type);
	}

	public BackPack getBackpack() {
		return this.pack;
	}

	public void removeAllPokemoninBelt() {
		belt.removAll();
	}

	public int getItemNum(ItemType type) {
		return this.pack.numItem(type);
	}

	public boolean isInBattle() {
		return this.isInBattle;
	}

	public boolean meetPokemon() { // null means no pokemon meet
		String[][] theMap = map.getMap(this.mapIndex);
		if (theMap[this.getY()][this.getX()].equals("g")) { // if in grass
			if (Math.random() < 0.2) { // 30% chance to meet pokemon
				this.isInBattle = true;
				return true;
			} else {
				return false;
			}
		} else { // not in grass
			return false;
		}
	}

}