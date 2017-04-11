package model;

public class Torros extends Pokemon{

	public Torros() {
		super(PokemonType.TORROS, 250, 30, PokemonRarity.COMMON);
	}

	@Override
	public void eatBait() {
		changeFleeChance(15);
		changeCatchChance(20);
	}

	@Override
	public void HitByRock() {
		changeFleeChance(-20);
		changeCatchChance(-15);
		takeDamage(20);
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
