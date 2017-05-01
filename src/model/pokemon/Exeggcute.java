package model.pokemon;

import model.Pokemon;

public class Exeggcute extends Pokemon{

	public Exeggcute() {
		super(PokemonType.EXEGGCUTE, 200, 30, PokemonRarity.COMMON);
		this.setPics("image/PokemonSprites/exeggcute-1.png", "image/PokemonSprites/exeggcute-2.png", 
				"image/PokemonSprites/exeggcute-3.png", "image/PokemonSprites/exeggcute-4.png", 
				"image/PokemonSprites/exeggcute-5.png");
	}

	@Override
	public void eatBait() {
		changeFleeChance(-16);
		changeCatchChance(-12);
		setEating(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void HitByRock() {
		changeFleeChance(13);
		changeCatchChance(20);
		takeDamage(20);
		setEating(false);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chooseAttack() {
		// TODO Auto-generated method stub
		
	}

}
