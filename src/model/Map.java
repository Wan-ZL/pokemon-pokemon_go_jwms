package model;

import java.io.Serializable;

/*
 * Map class to implement the game map
 */
public class Map implements Serializable {

	private static final long serialVersionUID = -7371246715182810289L;

	//The map will be an 2D array
	private String[][] map;

	//Constructor
	public Map(String[][] map) {
		this.map = map;
	}

	//return the map
	public String[][] getMap() {
		return map;
	}

	//return the location in the map
	public String getLocation(int x, int y) {
		return map[x][y];
	}

	//return the map as a string
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				str += map[i][j];
			}
			str += "\n";
		}
		return str;
	}

}

