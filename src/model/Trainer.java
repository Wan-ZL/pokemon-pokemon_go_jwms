package model;

import java.io.Serializable;
import java.util.ArrayList;

import java.awt.Point;

import controller.MapCreater;
import model.items.Item;
import model.items.SafariBall;

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
	private static int trainerX;
	private static int trainerY;
	private boolean positionChanged;
	private boolean moved;

	private int map; // 1 means trainer in map1, 2 means trainer in map2

	private static Trainer thisTrainer;
	private Game gamedata;

	Trainer(String name, int x, int y) {
		this.step = 500;
		this.map = 1;
		this.theMap = gamedata.getMap();
		this.pack = new BackPack();
		this.belt = new PokemonBelt();
		pack.addItem(new SafariBall(30));
		this.name = name;
		this.trainerDirection = "down";
		this.trainerPosition = new Point();
		this.trainerX = x;
		this.trainerY = y;
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
		return this.trainerX;
	}

	public int getY() { // return trainer y position
		return this.trainerY;
	}
	
	public void setX(int x) { // set trainer x position
		this.trainerX = x;
	}

	public void setY(int y) { // set trainer y position
		this.trainerY = y;
	}

	public String getTrainerDirection() { // return the trainer direction
		return this.trainerDirection;
	}
	
	public void setTrainerDirectionTo(String direc) { // set the trainer direction
		this.trainerDirection = direc;
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
			thisTrainer = new Trainer("Trainer Name", trainerX, trainerY);
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
	
	public void setStep(int step) {
		this.step = step;
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
		return this.theMap.getMap();
	}

	public String getItemOnMap(int i, int j) { // return the Item on map, like
												// tree or stone. return value
												// is String
		return this.theMap.getLocation(i, j);
	}

	public void removeAllPokemoninBelt() { // remove all pokemon in belt. (new
											// pokemonbelt)
		this.belt = new PokemonBelt();
	}

	public Pokemon getPokemon(int index) {
		return this.belt.getBeltArray().get(index);
	}
	
	//Make the trainer move
	public boolean move(String move) {
		int flag = 0;
		boolean moved = false;

		int x = gamedata.getCurrentX();
		int y = gamedata.getCurrentY();

		int originalX = gamedata.getCurrentX();
		int originalY = gamedata.getCurrentY();

		String originalFace = gamedata.getTrainerDirection();

		if (move.equals("up") && y - 1 >= 0) {
			if ((theMap.getLocation(y - 1, x).equals("n") || theMap.getLocation(y - 1, x).equals("g")
					|| theMap.getLocation(y - 1, x).equals("s") || theMap.getLocation(y - 1, x).equals("l"))
					&& !theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentY(y - 1);
				gamedata.setTrainerY(y - 1);
				flag = 1;
				moved = true;
			} else if (theMap.getLocation(y - 1, x).equals("b") && theMap.getLocation(y, x).equals("l")) {
				gamedata.setCurrentY(y - 1);
				gamedata.setTrainerY(y - 1);
				flag = 1;
				moved = true;
			} else if (theMap.getLocation(y - 1, x).equals("b") && theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentY(y - 1);
				gamedata.setTrainerY(y - 1);
				flag = 1;
				moved = true;
			}
			gamedata.setTrainerDirection("up");
		} else if (move.equals("down") && y + 1 < theMap.getMap().length) {
			if ((theMap.getLocation(y + 1, x).equals("n") || theMap.getLocation(y + 1, x).equals("g")
					|| theMap.getLocation(y + 1, x).equals("s") || theMap.getLocation(y + 1, x).equals("l"))
					&& !theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentY(y + 1);
				gamedata.setTrainerY(y + 1);
				flag = 1;
				moved = true;
			}

			else if (theMap.getLocation(y + 1, x).equals("b") && theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentY(y + 1);
				gamedata.setTrainerY(y + 1);
				flag = 1;
				moved = true;
			} else if (theMap.getLocation(y + 1, x).equals("l") && theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentY(y + 1);
				gamedata.setTrainerY(y + 1);
				flag = 1;
				moved = true;
			}
			gamedata.setTrainerDirection("down");
		} else if (move.equals("right") && x + 1 < theMap.getMap()[0].length) {
			gamedata.setTrainerDirection("right");
			if (theMap.getLocation(y, x + 1).equals("n") || theMap.getLocation(y, x + 1).equals("g")
					|| theMap.getLocation(y, x + 1).equals("s") || theMap.getLocation(y, x + 1).equals("l")) {
				gamedata.setCurrentX(x + 1);
				gamedata.setTrainerX(x + 1);
				flag = 1;
				moved = true;
			}

			else if (theMap.getLocation(y, x + 1).equals("b") && theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentX(x + 1);
				gamedata.setTrainerX(x + 1);
				flag = 1;
				moved = true;
			}

		} else if (move.equals("left") && x - 1 >= 0) {
			gamedata.setTrainerDirection("left");
			if (theMap.getLocation(y, x - 1).equals("n") || theMap.getLocation(y, x - 1).equals("g")
					|| theMap.getLocation(y, x - 1).equals("s") || theMap.getLocation(y, x - 1).equals("l")) {
				gamedata.setCurrentX(x - 1);
				gamedata.setTrainerX(x - 1);
				flag = 1;
				moved = true;
			}

			else if (theMap.getLocation(y, x - 1).equals("b") && theMap.getLocation(y, x).equals("b")) {
				gamedata.setCurrentX(x - 1);
				gamedata.setTrainerX(x - 1);
				flag = 1;
				moved = true;
			}

		}

		if (!gamedata.getTrainerDirection().equals(originalFace)) {
			positionChanged = true;
		}

		if (originalX != gamedata.getCurrentX() || originalY != gamedata.getCurrentY()) {
			positionChanged = true;
		}

		x = gamedata.getTrainer().getX();
		y = gamedata.getTrainer().getY();

		if (x == 35 && y == 10 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(1, "right", 1, 21);
		}

		if (x == 35 && y == 11 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(1, "right", 1, 22);
		}

		if (x == 0 && y == 21 && gamedata.getMapNumber() == 1) {
			this.moveTrainer(0, "entrance", 34, 10);
		}

		if (x == 0 && y == 22 && gamedata.getMapNumber() == 1) {
			this.moveTrainer(0, "entrance", 34, 11);
		}

		if (x == 0 && y == 5 && gamedata.getMapNumber() == 1) {
			this.moveTrainer(2, "top", 34, 22);
		}

		if (x == 0 && y == 6 && gamedata.getMapNumber() == 1) {
			this.moveTrainer(2, "top", 34, 23);
		}

		// top map
		if (x == 35 && y == 22 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(1, "right", 1, 5);
		}
		if (x == 35 && y == 23 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(1, "right", 1, 6);
		}

		// first map bottom to top
		if (x == 15 && y == 0 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(0, "entrance", 17, 24);
		}
		if (x == 16 && y == 0 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(0, "entrance", 18, 24);
		}

		if (x == 18 && y == 25 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(2, "top", 16, 1);
		}
		if (x == 17 && y == 25 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(2, "top", 15, 1);
		}

		// for left gate in first map
		if (x == 35 && y == 3 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(0, "entrance", 1, 12);
		}

		if (x == 35 && y == 4 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(0, "entrance", 1, 13);
		}

		if (x == 0 && y == 13 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(0, "entrance", 34, 4);
		}

		if (x == 0 && y == 12 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(0, "entrance", 34, 3);
		}

		// for top gate in first map
		if (x == 22 && y == 25 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(0, "entrance", 10, 1);
		}
		if (x == 23 && y == 25 && gamedata.getMapNumber() == 2) {
			this.moveTrainer(0, "entrance", 11, 1);
		}
		if (x == 10 && y == 0 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(2, "top", 22, 24);
		}
		if (x == 11 && y == 0 && gamedata.getMapNumber() == 0) {
			this.moveTrainer(2, "top", 23, 24);
		}
		// System.out.println(x + " " + y);

		if (flag != 0) {
			gamedata.setTrainerStep(gamedata.getTrainer().getStep() - flag);
		}

		return moved;
	}
	
	/**
	 * Move trainer and set trainer on the map, or change map.
	 *
	 * @param mapNumber
	 *            the map number
	 * @param map
	 *            the map
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	private void moveTrainer(int mapNumber, String map, int x, int y) {
		gamedata.setMapNumber(mapNumber);
		gamedata.setMap(map);
		gamedata.setTrainer(x, y);
	}

}
