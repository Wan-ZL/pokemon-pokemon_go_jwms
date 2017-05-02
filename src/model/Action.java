package model;

public enum Action {

	EAT(7), RUN_AWAY_FAIL(12), RUN_AWAY_SUCCED(8), ATTACK(6), THROW_ROCK(4),
	THROW_BAIT(5), THROW_POKEBALL(6), NONE(-1);
	
	private int value;
	
	Action(int val) {
		value = val;
	}
	
	// gets the value of an action
	public int getValue() {
		return this.value;
	}
	
	// Get a string describing the action
	/*public String toString() {
		if (value == 0) {
			return "is eating!";
		} else if (value == 1) {
			return "failed to run away!";
		} else if (value == 2) {
			return "ran away!";
		} else if (value == 3) {
			return "attacks!";
		} else if (value == 4) {
			return "threw a rock!";
		} else if (value == 5) {
			return "threw bait!";
		} else if (value == 6) {
			return "threw a pokeball!";
		} else {
			return "NA";
		}
		
		
	}*/
}
