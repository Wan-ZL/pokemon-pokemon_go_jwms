package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	private JPanel battlePan;
	// a button shows "throw A safari ball".
	private JButton throwASafariBall;
	// a button shows "throw A rock".
	private JButton throwARock;
	// a button shows "run away". 
	private JButton runAway;
	// a button shows "give bait".
	private JButton ThrowABait;
	
	private Image backGround;
	private JTextArea TrainerHealth;
	private JTextArea PokemonHealth;
	
	private MediaPlayer sound;
	//Sound for run away
	private static final String RUNAWAY = Paths.get("sounds/runsAway.mp3").toUri().toString();

	//Sound for throw a bait
	private static final String THROWBAIT = Paths.get("sounds/bait.mp3").toUri().toString();

	//Sound for catch a pokemon
	private static final String POKECAUGHT = Paths.get("sounds/caught.mp3").toUri().toString();

	//Sound for throw a rock
	private static final String THROWROCK = Paths.get("sounds/rock.mp3").toUri().toString();
	
	//Sound for throw a safari ball
	private static final String THROWBALL = Paths.get("sounds/throwball.mp3").toUri().toString();
	
	public BattleView(Trainer trainer) {
		
		this.trainer = trainer;
		encounter = new Encounter(getPokemon(), trainer);
		battlePan = new JPanel();
		this.setPreferredSize(new Dimension((20*11)+215, 20*11));
		this.setLayout(null);
		//this.setBackground(Color.BLACK);
		throwASafariBall = new JButton("Throw A Safari Ball");
		throwARock = new JButton("Throw A Rock");
		runAway = new JButton("Run Away");
		ThrowABait = new JButton("Throw A Bait");
		
		
		
		TrainerHealth = new JTextArea("");
		PokemonHealth = new JTextArea("");
		
		TrainerHealth.setEditable(false);
		throwASafariBall.setSize(215, 45);
		throwASafariBall.setLocation(215, 0);
		throwARock.setSize(215, 45);
		throwARock.setLocation(215, 45);
		ThrowABait.setSize(215, 45);
		ThrowABait.setLocation(215, 90);
		runAway.setSize(215, 45);
		runAway.setLocation(215, 135);
		
		TrainerHealth.setSize((int) 107.5, 40);
		TrainerHealth.setLocation(215, 180);
		TrainerHealth.setBackground(Color.WHITE);
		TrainerHealth.replaceSelection("Trainer: ");
		//TrainerHealth.setAlignmentX(CENTER_ALIGNMENT);
		//TrainerHealth.setAlignmentY(CENTER_ALIGNMENT);
		PokemonHealth.setSize((int) 107.5, 40);
		PokemonHealth.setLocation((int) 322.5, 180);
		PokemonHealth.setBackground(Color.WHITE);
		PokemonHealth.replaceSelection("Pokemon: ");
		//throwASafariBall.setBounds(370, 380, 150, 30);
		//throwARock.setBounds(520, 380, 150, 30);
		//runAway.setBounds(520, 420, 150, 30);
		//ThrowABait.setBounds(370, 420, 150, 30);
		
		this.add(ThrowABait);
		this.add(runAway);
		this.add(throwARock);
		this.add(throwASafariBall);
		this.add(PokemonHealth);
		this.add(TrainerHealth);
		
		runAway.addActionListener(new RunAwayListener());
		throwARock.addActionListener(new ThrowARocklListener());
		throwASafariBall.addActionListener(new ThrowASafariBallListener());
		ThrowABait.addActionListener(new ThrowBaitListener());
		
		/*JScrollPane scroll = new JScrollPane(TrainerHealth);
		scroll.setBounds(50, 350, 300, 150);
		this.add(scroll);*/
		
		try {
			backGround = ImageIO.read(new File("image/battle_bg.jpg"));
		} catch (IOException e) {
			System.out.println("Cannot find the image file!");
			e.printStackTrace();
		}
		repaint();
	}
	
	//Four buttons: Throw a rock; Throw bait; Throw Pokeball; Run
	
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
	
	public void updatePanel() {
				repaint();
	}
	
	// Listener for run away
	private class RunAwayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			playSong(RUNAWAY);
		}

	}
	
	//Listener for throw a safari ball
	private class ThrowASafariBallListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//throw a safari ball first
			playSong(THROWBALL);
			
			//TODO: check if pokemon is caught
			if(encounter.isCaught()){
				playSong(POKECAUGHT);
			}
		}
		
	}
	
	//Listener for throw a rock
	private class ThrowARocklListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			playSong(THROWROCK);
		}
		
	}
	
	//Listener for throw a bait
	private class ThrowBaitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			playSong(THROWBAIT);
		}
		
	}
	
	private void playSong(String file) {
		if (this.sound != null) {
			this.sound.stop();
			this.sound.dispose();
		}
		Media song = new Media(file);
		this.sound = new MediaPlayer(song);
		// The song will repeat forever
		this.sound.play();
	}
}
