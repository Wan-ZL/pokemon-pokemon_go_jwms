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
		return null;
	}
}
