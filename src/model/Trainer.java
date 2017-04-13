package model;

import java.awt.Point;

import model.items.SafariBall;

public class Trainer {

	private String name;
	private BackPack pack;
	private PokemonBelt belt;
	private String trainerDirection;				// the trainer direction. Type is String
	private Point trainerPosition;					// the trainer position. Type is Point. Point initial is (0,0)
	private boolean positionChanged;
	private boolean moved;
	
	private static Trainer thisTrainer;
	
	private Trainer(String name) {
		this.pack = new BackPack();
		pack.addItem(new SafariBall(30));
		this.name = name;
		this.trainerDirection = "down";
		this.trainerPosition = new Point();
		this.trainerPosition.setLocation(0, 0);
		this.positionChanged = false;
		this.moved = false;
		
		
	}
	
	public boolean MoveChanged(){
		return this.moved;
	}
	
	public void setChangedMove(boolean status){
		this.moved = status;
	}
	
	public int getX(){						// return trainer x position
		return (int) this.trainerPosition.getX();
	}
	
	public int getY(){						// return trainer y position
		return (int) this.trainerPosition.getY();
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
	
	public static Trainer getTrainerInstance(){		// create instance variable of trainer
		if(thisTrainer == null){
			thisTrainer = new Trainer("Trainer Name");
		}
		return thisTrainer;
	}
	
	
	public boolean addPokemon(Pokemon pokemon){		// add a pokemon to belt, return true if success
		return this.belt.addPokemon(pokemon);
	}
	
	public boolean removePokemon(Pokemon pokemon){	// remove a pokemon from belt, if have multi same pokemon, remove the first one.
		return this.belt.removePokemon(pokemon);
	}
	
	public Pokemon removePokemon(int index){		// remove a pokemon on specific index, return the removed pokemon object.
		return this.belt.removePokemon(index);
	}
	
	public Pokemon[] getBeltArray(){				// return the whole pokemon on belt, type is array of pokemon
		return this.belt.getBeltArray();
	}
	
	public int getSize(){							// return the number of pokemon on belt.
		return this.belt.getSize();
	}
}
