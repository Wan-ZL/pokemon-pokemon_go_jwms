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
	public int chooseAttack() {
		return 50;
		
	}

}
