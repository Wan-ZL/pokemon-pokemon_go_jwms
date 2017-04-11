package model;

public enum PokemonType {

	Tauros(0), Poliwag(1);
	
	private int value;
	
	PokemonType(int val) {
		value = val;
	}
	
	// gets the value of a pokemon type
	public int getValue() {
		return this.value;
	}
	
	// get the name of the pokemon as a string
	public String toString() {
		if (value == 0) {
			return "Toros";
		} else if (value == 1) {
			return "Ryhorn";
		}
		
		return "NA";
	}
}
