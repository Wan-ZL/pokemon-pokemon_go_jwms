package model.pokemon;

import model.Pokemon;

public class Pinsir extends Pokemon{

	public Pinsir() {
		super(PokemonType.PINSIR, 800, 30, PokemonRarity.UNCOMMON);
		this.setPics("image/PokemonSprites/pinsir-1.png", "image/PokemonSprites/pinsir-2.png", 
				"image/PokemonSprites/pinsir-3.png", "image/PokemonSprites/pinsir-4.png", 
				"image/PokemonSprites/pinsir-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-23);
		changeCatchChance(-14);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(13);
		changeCatchChance(17);
		takeDamage(18);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int performAttack() {
		// TODO Auto-generated method stub
		return 160;
	}

}
