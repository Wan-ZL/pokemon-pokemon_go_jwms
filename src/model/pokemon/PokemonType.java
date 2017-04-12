package model.pokemon;

public enum PokemonType {

	Mewtwo(0), Dragonair(1), Pinsir(2), Marowak(3), Tauros(4), Poliwag(5), Paras(6), Exeggcute(7), Parasect(8), Dratini(9);
	
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
