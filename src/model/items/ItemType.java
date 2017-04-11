package model.items;

public enum ItemType {

	SAFARI_BALL(0), MAX_POTION(1), NUGGET(2);
	
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
			} else if (value == 12) {
				return "Nugget";
			}  else {
				return "NA";
			}
			
			
		}
	
}
