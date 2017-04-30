package model.items;

public enum ItemType {

	SAFARI_BALL(0), MAX_POTION(1), NUGGET(2), BAIT(3), ROCK(4);

	int value;

	ItemType(int val) {
		value = val;
	}

	// gets the value of a pokemon type
	public int getValue() {
		return this.value;
	}

	// get the name of the pokemon as a string
	public String toString() {
		if (value == 0) {
			return "Safari Ball";
		} else if (value == 1) {
			return "Max Potion";
		} else if (value == 2) {
			return "Nugget";
		} else if (value == 3) {
			return "Bait";
		} else if (value == 4) {
			return "Rock";
		} else {
			return "NA";
		}

	}

}
