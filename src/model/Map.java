package model;

import java.awt.Point;

public interface Map {

	// Returns a point of the trainers position
	public Point getTrainerPos();
	
	// Returns the char at a given point
	public TileObject getTile(Point pos);
	
	// Returns the current view of the map based on the trainer location
	public char[][] getCurMapView();
	
	// returns true only if the trainer can move to the location
	public boolean canMoveToTile(Point pos);
}
