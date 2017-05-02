package model.pokemon;

import model.Pokemon;

public class Mewtwo extends Pokemon{

	public Mewtwo() {
		super(PokemonType.MEWTWO, 1000, 100, PokemonRarity.RARE);
		this.setPics("image/PokemonSprites/mewtwo-1.png", "image/PokemonSprites/mewtwo-2.png", 
				"image/PokemonSprites/mewtwo-3.png", "image/PokemonSprites/mewtwo-4.png", 
				"image/PokemonSprites/mewtwo-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-12);
		changeCatchChance(-11);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(13);
		changeCatchChance(12);
		takeDamage(10);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int performAttack() {
		// TODO Auto-generated method stub
		return 100;
	}

}
