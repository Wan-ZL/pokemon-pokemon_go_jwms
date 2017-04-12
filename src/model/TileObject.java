package model;

public enum TileObject {

	TREE('T'), BUSH('B'), ROCK('R'), SHALLOW_WATER('w'), DEEP_WATER('W'), GRASS('G');
	
	char value;
	
	private TileObject(char val) {
		value = val;
	}
	
	// Return the value of the given enum
	public char getValue() {
		return value;
	}
	
	// Return a string of the enum
	public String toString() {
		if (value == 'T') {
			return "Tree";
		} else if (value == 'B') {
			return "Bush";
		} else if (value == 'R') {
			return "Rock";
		} else if (value == 'w') {
			return "Shallow Water";
		} else if (value == 'W') {
			return "Deep Water";
		} else if (value == 'G') {
			return "Grass";
		} else {
			return "NA";
		}
	}
}
