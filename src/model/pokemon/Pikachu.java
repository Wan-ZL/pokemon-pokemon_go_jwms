package model.pokemon;

import model.Pokemon;

public class Pikachu extends Pokemon{

	public Pikachu() {
		super(PokemonType.PIKACHU, 200, 25, PokemonRarity.COMMON);
		this.setPics("image/PokemonSprites/pikachu-1.png", "image/PokemonSprites/pikachu-2.png", 
				"image/PokemonSprites/pikachu-3.png", "image/PokemonSprites/pikachu-4.png", 
				"image/PokemonSprites/pikachu-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-15);
		changeCatchChance(-12);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(14);
		changeCatchChance(21);
		takeDamage(20);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int performAttack() {
		// TODO Auto-generated method stub
		return 25;
	}

}
