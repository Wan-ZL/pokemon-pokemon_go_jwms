package model.pokemon;

import model.Pokemon;

public class Tauros extends Pokemon{

	public Tauros() {
		super(PokemonType.TAUROS, 250, 30, PokemonRarity.COMMON);
		this.setPics("image/PokemonSprites/tauros-1.png", "image/PokemonSprites/tauros-2.png", 
				"image/PokemonSprites/tauros-3.png", "image/PokemonSprites/tauros-4.png", 
				"image/PokemonSprites/tauros-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-20);
		changeCatchChance(-12);
		setEating(true);
	}

	@Override
	public void HitByRock() {
		changeFleeChance(12);
		changeCatchChance(20);
		takeDamage(20);
		setEating(false);
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
