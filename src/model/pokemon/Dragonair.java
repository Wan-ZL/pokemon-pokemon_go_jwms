package model.pokemon;

import model.Pokemon;

public class Dragonair extends Pokemon{

	public Dragonair() {
		super(PokemonType.DRAGONAIR, 400, 80, PokemonRarity.UNCOMMON);
		this.setPics("image/PokemonSprites/dragonair-1.png", "image/PokemonSprites/dragonair-2.png", 
				"image/PokemonSprites/dragonair-3.png", "image/PokemonSprites/dragonair-4.png", 
				"image/PokemonSprites/dragonair-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-18);
		changeCatchChance(-12);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(13);
		changeCatchChance(16);
		takeDamage(15);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int performAttack() {
		return 50;
		
	}

}
