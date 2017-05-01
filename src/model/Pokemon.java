package model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Random;

import model.pokemon.PokemonRarity;
import model.pokemon.PokemonType;

/*
 *  This is the super class Pokemon that inherits all other Pokemon classes
 */
public abstract class Pokemon implements Serializable{

	private static final long serialVersionUID = -8459011650859112417L;
	
	private Random rand = new Random();
	private PokemonType type;
	private PokemonRarity rarity;
	protected int hp, lvl, speed, damage, fleeChance, catchChance;
	private boolean eatingBait;
	private String[] pics;
	
	// super class constructor
	public Pokemon(PokemonType type, int baseHP, int baseSpeed, PokemonRarity rarity) {
		this.type = type;
		this.speed = baseSpeed + rand.nextInt(20);
		this.rarity = rarity;
		this.damage = 0;
		this.lvl = 25 + rand.nextInt(10);
		this.hp = baseHP + rand.nextInt(75) + (lvl*rand.nextInt(4));
		this.fleeChance = 12 * this.rarity.getValue();
		this.catchChance = 42 / this.rarity.getValue();
	}
	
	// set all the pic pocations
	public void setPics(String pic1, String pic2, String pic3, String pic4, String pic5) {
		pics = new String[5];
		this.pics[0] = pic1;
		this.pics[1] = pic2;
		this.pics[2] = pic3;
		this.pics[3] = pic4;
		this.pics[4] = pic5;
	}
	
	// get a list of picture locations
	public String getPic(int index) {
		return pics[index];
	}
	
	// returns the type of the Pokemon as a string
	public String getName() {
		return this.type.toString();
	}
	
	
	// returns the level of the Pokemon
	public int getLevel() {
		return this.lvl;
	}
	
	// returns the max health of the Pokemon
	public int getMaxHP() {
		return this.hp;
	}
	
	// returns the speed of the Pokemon
	public int getSpeed() {
		return this.speed;
	}
	
	// return a String of the rarity
	public String getRarity() {
		return this.rarity.toString();
	}
	
	// returns the current health of the Pokemon
	public int getCurHP() {
		return hp-damage;
	}
	
	// return true if Pokemon is knocked out
	public boolean isKnockedOut() {
		return damage >= hp;
	}
	
	// return the current flee chance
	public int getFleeChance() {
		return fleeChance;
	}
	
	// return the current catch chance
	public int getCatchChance() {
		return catchChance;
	}
	
	// check if the Pokemon flees
	public boolean fleeCheck() {
		if (rand.nextInt(100) < fleeChance) 
			return true;
		else
			return false;
	}
	
	// check if the Pokemon flees
	public boolean catchCheck() {
		if (rand.nextInt(100) < catchChance) 
			return true;
		else
			return false;
	}
	
	// returns true if the pokemon is eating
	public boolean isEating() {
		return eatingBait;
	}
	
	// Set eatingBait
	public void setEating(Boolean eating) {
		eatingBait = eating;
	}
	
	// Take damage
	public void takeDamage(int damage) {
		this.damage += damage;
		if (damage > hp) { // can't have more damage than health
			this.damage = hp;
		}
	}
	
	// Changes the fleeChance by the amount
	public void changeFleeChance(int amt) {
		this.fleeChance += amt;
	}
	
	// Changes the catchChance
	public void changeCatchChance(int amt) {
		this.catchChance += amt;
	}
	

	// Choose an action 
	public Action chooseAction() {
		if (isEating()) {
			return Action.EAT;
		} else if (fleeCheck()) {
			return Action.RUN_AWAY_SUCCED;
		} else {
			return Action.ATTACK;
		}
	}
	
	// Choose an attack to use
	public abstract int chooseAttack();
	
	// Increases catchChance but also fleeChance
	public abstract void eatBait();
	
	// Decreases fleeCHance but also catchChance
	public abstract void HitByRock();
	
	
	
	
}
