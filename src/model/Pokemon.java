package model;

import java.util.Random;

import model.pokemon.PokemonRarity;
import model.pokemon.PokemonType;

/*
 *  This is the super class Pokemon that inherits all other Pokemon classes
 */
public abstract class Pokemon {

	private Random rand = new Random();
	private PokemonType type;
	private PokemonRarity rarity;
	private int hp, lvl, speed, damage, fleeChance, catchChance;
	private boolean eatingBait;
	
	// super class constructor
	public Pokemon(PokemonType type, int baseHP, int baseSpeed, PokemonRarity rarity) {
		this.type = type;
		this.hp = baseHP + rand.nextInt(75);
		this.speed = baseSpeed + rand.nextInt(20);
		this.rarity = rarity;
		this.damage = 0;
		this.lvl = 25 + rand.nextInt(10);
		this.fleeChance = 12 * this.rarity.getValue();
		this.catchChance = 42 / this.rarity.getValue();
	}
	
	// returns the type of the Pokemon as a string
	public String getType() {
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
		if (rand.nextInt(100) > fleeChance) 
			return true;
		else
			return false;
	}
	
	// returns true if the pokemon is eating
	public boolean isEating() {
		return eatingBait;
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
	
	// Increases catchChance but also fleeChance
	public abstract void eatBait();
	
	// Decreases fleeCHance but also catchChance
	public abstract void HitByRock();
	
	// Choose an action 
	public PokemonAction chooseAction() {
		if (isEating()) {
			return PokemonAction.EAT;
		} else if (fleeCheck()) {
			return PokemonAction.RUN_AWAY_SUCCED;
		} else {
			return PokemonAction.ATTACK;
		}
	}
	
	// Choose an attack to use
	public abstract void chooseAttack();
	
	
	
	
	
}
