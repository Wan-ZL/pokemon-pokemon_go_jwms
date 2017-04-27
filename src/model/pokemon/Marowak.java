package model.pokemon;

import model.Pokemon;

public class Marowak extends Pokemon{

	public Marowak() {
		super(PokemonType.MAROWAK, 500, 60, PokemonRarity.UNCOMMON);
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
