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
