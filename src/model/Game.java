package model;

import java.io.Serializable;
import java.util.Observable;

import controller.MapCreater;;

/**
 * The Class GameData will store all dates about the pokemon game.
 */
public class Game extends Observable implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7292893644893428683L;

	/** a trainer. */
	private Trainer trainer;

	/** The map. */
	private Map map;
	
	private int mapNumber;

	/** The current Y axis and X axis. */
	private int currentX, currentY;

	//constructor
	public Game(String name) {
		trainer = new Trainer(name, 18, 24);
		//TODO: want to initialize the map to the start map
		map = new MapCreater("entrance").getTheMap();
		mapNumber = 0;
		currentX = trainer.getX();
		currentY = trainer.getY();
	}

	//return the trainer
	public Trainer getTrainer() {
		return trainer;
	}

	//set the trainer's location
	public void setTrainer(int x, int y) {
		this.trainer.setX(x);
		this.trainer.setY(y);

		currentX = trainer.getX();
		currentY = trainer.getY();

		setChanged();
		notifyObservers();
	}

	//set trainer's X
	public void setTrainerX(int x) {
		this.trainer.setX(x);

		setChanged();
		notifyObservers();
	}

	//set trainer's Y
	public void setTrainerY(int y) {
		this.trainer.setY(y);

		setChanged();
		notifyObservers();
	}

	//set trainer's steps
	public void setTrainerStep(int steps) {
		this.trainer.setStep(steps);
		setChanged();
		notifyObservers();
	}

	//return the map
	public Map getMap() {
		return map;
	}

	//set the map
	public void setMap(String map) {
		//TODO: want to set the map
		this.map = new MapCreater(map).getTheMap();

		setChanged();
		notifyObservers();
	}

	//return current X
	public int getCurrentX() {
		return currentX;
	}

	//return current Y
	public int getCurrentY() {
		return currentY;
	}

	//set current X
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
		setChanged();
		notifyObservers();
	}

	//set current X
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
		setChanged();
		notifyObservers();
	}

	//set safari ball amount
	public void setTrainerSafariBall() {
		//TODO: notify the change amount of balls
		getSafariBall() - 1;
		setChanged();
		notifyObservers();
	}

	//set pokemon list
	public void setTrainerPokemonList(Pokemon pokemon) {
		trainer.addPokemon(pokemon);
		setChanged();
		notifyObservers();
	}

	//get the map number
	public int getMapNumber() {
		return mapNumber;
	}

	//set the map number
	public void setMapNumber(int mapNumber) {
		this.mapNumber = mapNumber;
		setChanged();
		notifyObservers();
	}

	//return trainer's direction
	public String getTrainerDirection() {
		return trainer.getTrainerDirection();
	}

	//return trainer's direction
	public void setTrainerDirection(String direc) {
		trainer.setTrainerDirection(direc);
		setChanged();
		notifyObservers();
	}

}
