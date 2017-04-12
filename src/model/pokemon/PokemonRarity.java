package model.pokemon;

public enum PokemonRarity {

	COMMON(1), UNCOMMON(2), RARE(3);
	
	private int value;
	
	PokemonRarity(int val) {
		value = val;
	}
	
	// gets the value of a rarity
	public int getValue() {
		return this.value;
	}
	
	// gets a string of the rarity
	public String toString() {
		if (value == 1) {
			return "Common";
		} else if (value == 2) {
			return "Uncommon";
		} else {
			return "Rare";
		}
	}
}
