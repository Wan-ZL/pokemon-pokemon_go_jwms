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
	
}
