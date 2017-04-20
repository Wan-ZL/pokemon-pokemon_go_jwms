package model.pokemon;

import model.Pokemon;

public class Tauros extends Pokemon{

	public Tauros() {
		super(PokemonType.Tauros, 250, 30, PokemonRarity.COMMON);
	}

	@Override
	public void eatBait() {
		changeFleeChance(15);
		changeCatchChance(20);
		setEating(true);
	}

	@Override
	public void HitByRock() {
		changeFleeChance(-20);
		changeCatchChance(-15);
		takeDamage(20);
		setEating(false);
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
