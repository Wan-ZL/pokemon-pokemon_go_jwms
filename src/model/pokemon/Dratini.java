package model.pokemon;

import model.Pokemon;

public class Dratini extends Pokemon{

	public Dratini() {
		super(PokemonType.DRATINI, 150, 35, PokemonRarity.COMMON);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eatBait() {
		changeFleeChance(15);
		changeCatchChance(20);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(-20);
		changeCatchChance(-15);
		takeDamage(20);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
