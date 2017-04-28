package model.pokemon;

public enum PokemonType {

	MEWTWO(0), DRAGONAIR(1), PINSIR(2), MAROWAK(3), TAUROS(4), 
	PIKACHU(5), PARAS(6), EXEGGCUTE(7), PRIMEAPE(8), DRATINI(9);
	
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
			return "Mewtwo";
		} 
		else if (value == 1) {
			return "Dragonair";
		}
		else if(value == 2){
			return "Pinsir";
		}
		else if(value == 3){
			return "Marowak";
		}
		else if(value == 4){
			return "Tauros";
		}
		else if(value == 5){
			return "Poliwag";
		}
		else if(value == 6){
			return "Paras";
		}
		else if(value == 7){
			return "Exeggcute";
		}
		else if(value == 8){
			return "Primeape";
		}
		else if(value == 9){
			return "Dratini";
		}
		return "NA";
	}
}
