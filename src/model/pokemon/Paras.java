package model.pokemon;

import model.Pokemon;

public class Paras extends Pokemon{

	public Paras() {
		super(PokemonType.PARAS, 200, 20, PokemonRarity.COMMON);
		this.setPics("image/PokemonSprites/paras-1.png", "image/PokemonSprites/paras-2.png", 
				"image/PokemonSprites/paras-3.png", "image/PokemonSprites/paras-4.png", 
				"image/PokemonSprites/paras-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-15);
		changeCatchChance(-15);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(20);
		changeCatchChance(25);
		takeDamage(35);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
