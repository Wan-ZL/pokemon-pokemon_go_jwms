package model.pokemon;

import model.Pokemon;

public class Primeape extends Pokemon{

	public Primeape() {
		super(PokemonType.PRIMEAPE, 300, 20, PokemonRarity.COMMON);
		this.setPics("image/PokemonSprites/primeape-1.png", "image/PokemonSprites/primeape-2.png", 
				"image/PokemonSprites/primeape-3.png", "image/PokemonSprites/primeape-4.png", 
				"image/PokemonSprites/primeape-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-13);
		changeCatchChance(-12);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(14);
		changeCatchChance(10);
		takeDamage(20);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int performAttack() {
		// TODO Auto-generated method stub
		return 53;
	}

}
