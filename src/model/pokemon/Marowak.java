package model.pokemon;

import model.Pokemon;

public class Marowak extends Pokemon{

	public Marowak() {
		super(PokemonType.MAROWAK, 500, 60, PokemonRarity.UNCOMMON);
		this.setPics("image/PokemonSprites/marowak-1.png", "image/PokemonSprites/marowak-2.png", 
				"image/PokemonSprites/marowak-3.png", "image/PokemonSprites/marowak-4.png", 
				"image/PokemonSprites/marowak-5.png");
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
		return 25;
		
	}

}
