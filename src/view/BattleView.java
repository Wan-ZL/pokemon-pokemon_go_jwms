package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.Encounter;
import model.Pokemon;
import model.Trainer;
import model.pokemon.Dragonair;
import model.pokemon.Dratini;
import model.pokemon.Exeggcute;
import model.pokemon.Marowak;
import model.pokemon.Mewtwo;
import model.pokemon.Paras;
import model.pokemon.Parasect;
import model.pokemon.Pinsir;
import model.pokemon.Poliwag;
import model.pokemon.Tauros;

public class BattleView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4796227636732972155L;

	private Trainer trainer;
	private Encounter encounter;
	private Random rand = new Random();
	private Timer timer;
	
	private Image backGround;
	
	public BattleView(Trainer trainer) {
		this.trainer = trainer;
		encounter = new Encounter(getPokemon(), trainer);
		this.setPreferredSize(new Dimension(20*11, 20*11));
		this.setLayout(null);
		try {
			backGround = ImageIO.read(new File("image/battle_bg.jpg"));
		} catch (IOException e) {
			System.out.println("Cannot find the image file!");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(backGround, 11*20, 11*20, null);
	}

	private Pokemon getPokemon() {
		// TODO get a random int to choose which pokemon to create for the
		//      encounter.
		int rarity = rand.nextInt(10);
		if (rarity == 0) {                   // Rare Pokemon
			return new Mewtwo();
		} else if (rarity < 4) {             // uncommon
			int num = rand.nextInt(2);
			if (num == 0) 
				return new Dragonair();
			else if (num == 1)
				return new Pinsir();
			else 
				return new Marowak();
		} else {                             // common
			int num = rand.nextInt(5);
			if (num == 0)
				return new Tauros();
			else if (num == 1)
				return new Poliwag();
			else if (num == 2)
				return new Paras();
			else if (num == 3)
				return new Exeggcute();
			else if (num == 4)
				return new Parasect();
			else
				return new Dratini();
		}
		
	}
}
