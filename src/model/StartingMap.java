package model;

import java.awt.Point;

public class StartingMap implements Map{

	private char[][] map;
	private final int MAP_SIZE = 50;
	
	public StartingMap() {
		map = new char[MAP_SIZE][MAP_SIZE];
	}
	
	@Override
	public Point getTrainerPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getTile(Point pos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char[][] getCurMapView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canMoveToTile(Point pos) {
		// TODO Auto-generated method stub
		return false;
	}

}
