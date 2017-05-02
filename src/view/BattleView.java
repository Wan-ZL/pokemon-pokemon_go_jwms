package view;

import java.awt.BorderLayout;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.imageio.ImageIO;

import controller.pokemonGUI;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Encounter;
import model.Pokemon;
import model.Trainer;
import model.items.ItemType;
import model.pokemon.Dragonair;
import model.pokemon.Dratini;
import model.pokemon.Exeggcute;
import model.pokemon.Marowak;
import model.pokemon.Mewtwo;
import model.pokemon.Paras;
import model.pokemon.Primeape;
import model.pokemon.Pinsir;
import model.pokemon.Pikachu;
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
	private int phase, count;
	private JPanel battlePan;
	// a button shows "throw A safari ball".
	private JButton throwASafariBall;
	// a button shows "throw A rock".
	private JButton throwARock;
	// a button shows "run away". 
	private JButton runAway;
	// a button shows "give bait".
	private JButton ThrowABait;
	
	private Image background;
	private JTextArea TrainerHealth;
	private JTextArea PokemonHealth;
	private boolean drawing;
	private Image trainerBase, trainerDamage, trThrow[], safariBall, rock, bait;
	
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
	
	private pokemonGUI mainFrame;
	public BattleView(Trainer trainer, pokemonGUI mainFrame) {
		drawing = false;
		phase = 0;
		count = 0;
		JFXPanel fxPanel = new JFXPanel();
		this.mainFrame = mainFrame;
		this.trainer = trainer;
		encounter = new Encounter(getPokemon(), trainer);
		//battlePan = new JPanel();
		this.setPreferredSize(new Dimension((20*11)+215, 20*11));
		this.setLayout(null);
		//this.setBackground(Color.BLACK);
		throwASafariBall = new JButton("Throw A Safari Ball");
		throwARock = new JButton("Throw A Rock");
		runAway = new JButton("Run Away");
		ThrowABait = new JButton("Throw A Bait");
		
		timer = new Timer(100, new animationListener());
		
		TrainerHealth = new JTextArea(trainer.getCurrHP() + "/" + trainer.getMaxHP());
		PokemonHealth = new JTextArea(encounter.getPokemonHP());
		
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
		TrainerHealth.replaceSelection(trainer.getName() + ": ");
		//TrainerHealth.setAlignmentX(CENTER_ALIGNMENT);
		//TrainerHealth.setAlignmentY(CENTER_ALIGNMENT);
		PokemonHealth.setSize((int) 107.5, 40);
		PokemonHealth.setLocation((int) 322.5, 180);
		PokemonHealth.setBackground(Color.WHITE);
		PokemonHealth.replaceSelection(" " + encounter.getPokemonName() + ": ");
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
		trThrow = new Image[4];
		
		try {
			trainerBase = ImageIO.read(new File("image/TrainerSprites/trainer-base.png"));
			trainerDamage = ImageIO.read(new File("image/TrainerSprites/trainer-damage.png"));
			trThrow[0] = ImageIO.read(new File("image/TrainerSprites/trainer-1.png"));
			trThrow[1] = ImageIO.read(new File("image/TrainerSprites/trainer-2.png"));
			trThrow[2] = ImageIO.read(new File("image/TrainerSprites/trainer-3.png"));
			trThrow[3] = ImageIO.read(new File("image/TrainerSprites/trainer-4.png"));
			safariBall = ImageIO.read(new File("image/TrainerSprites/safari-ball.png"));
			rock       = ImageIO.read(new File("image/TrainerSprites/rock.png"));
			bait       = ImageIO.read(new File("image/TrainerSprites/bait.png"));
		} catch (IOException e1) {
			System.out.println("Cannot find the image file.");
			e1.printStackTrace();
		}
		
		/*JScrollPane scroll = new JScrollPane(TrainerHealth);
		scroll.setBounds(50, 350, 300, 150);
		this.add(scroll);*/
//		ImageIcon image = new ImageIcon("image/rsz_battle_bg.jpg");
//		JLabel label = new JLabel("", image, JLabel.CENTER);
//		label.setLocation(0, 0);
//		label.setSize(215, 220);
//		
//		this.add(label);
		
		try {
			background = ImageIO.read(new File("image/battle_bg.jpg"));
		} catch (IOException e) {
			System.out.println("Cannot find the image file!");
			e.printStackTrace();
		}
		timer.start();
		//repaint();
	}
	
	//Four buttons: Throw a rock; Throw bait; Throw Pokeball; Run
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(background, 0, 0, 215, 220, null);
		
		if (phase == 0) { // Intro animations
			if (count < 5) {
				g2.drawImage(encounter.getPokeImg(count), 20*6, 50, null);
				g2.drawImage(trainerBase, count*10-50, 156, null);
			} else {
				g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
				g2.drawImage(trainerBase, 0, 156, null);
			}
		}
		else if (phase == 1) { // still animations
			g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
			g2.drawImage(trainerBase, 0, 156, null);
		}
		else if (phase == 2) { // throw rock 
			if (count < 4) {
				if (count > 0) {
					g2.drawImage(rock, 8 + (50*(count-1)), 156 - (40*(count-1)), null);
				}
				g2.drawImage(trThrow[count], 0, 156, null);
			} else {
				g2.drawImage(trThrow[3], 0, 156, null);
				PokemonHealth.setText(" " +encounter.getPokemonName() + ": " +encounter.getPokemonHP());
			}
			g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
		}
		else if (phase == 3) { // throw bait
			if (count < 4) {
				if (count > 0) {
					g2.drawImage(bait, 8 + (50*(count-1)), 156 - (40*(count-1)), null);
				}
				g2.drawImage(trThrow[count], 0, 156, null);
			} else {
				g2.drawImage(trThrow[3], 0, 156, null);
			}
			g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);	
		}
		else if (phase == 4) { // throw safari ball
			if (count < 4) {
				if (count > 0) {
					g2.drawImage(safariBall, 8 + (50*(count-1)), 156 - (40*(count-1)), null);
				}
				g2.drawImage(trThrow[count], 0, 156, null);
			} else {
				g2.drawImage(trThrow[3], 0, 156, null);
			}
			g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);	
		}
		else if (phase == 5) { // Trainer run away
			g2.drawImage(trainerBase, 0 - (count*10), 156, null);
			g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
		}
		else if (phase == 6) { // pokemon attack
			TrainerHealth.setText(trainer.getName() + ": " + trainer.getCurrHP() + "/" + trainer.getMaxHP());
			if (count % 2 == 0) {
				g2.drawImage(trainerBase, 0, 156, null);
			} else {
				g2.drawImage(trainerDamage, 0, 156, null);
			}
			
			if (count < 5) {
				g2.drawImage(encounter.getPokeImg(count), 20*6, 50, null);
			} else {
				g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
			}
		}
		else if (phase == 7) { // pokemon eat
			g2.drawImage(trainerBase, 0, 156, null);
			if (count % 2 == 0) {
				g2.drawImage(encounter.getPokeImg(4), 20*6, 60, null);
			} else {
				g2.drawImage(encounter.getPokeImg(4), 20*6, 50, null);
			}
		}
		else if (phase == 8) { // pokemon run
			g2.drawImage(trainerBase, 0, 156, null);
			g2.drawImage(encounter.getPokeImg(4), (20*6) + (count*20), 60, null);
		}
		else if (phase == 9) { // pokemon not caught
			g2.drawImage(trainerBase, 0, 156, null);
			if (count == 0) {
				g2.drawImage(safariBall, (20*6), 60, null);
			}
			else if (count < 5) {
				if (count % 2 == 0) {
					g2.drawImage(safariBall, (20*6) + 10, 60, null);
				} else {
					g2.drawImage(safariBall, (20*6) - 10, 60, null);
				}
			}
			else if (count == 5) {
				g2.drawImage(encounter.getPokeImg(4), (20*6), 50, null);
			}
		}
		else if (phase == 10) { // pokemon caught
			g2.drawImage(trainerBase, 0, 156, null);
			if (count == 0) {
				g2.drawImage(safariBall, (20*6), 60, null);
			}
			else if (count < 5) {
				if (count % 2 == 0) {
					g2.drawImage(safariBall, (20*6) + 10, 60, null);
				} else {
					g2.drawImage(safariBall, (20*6) - 10, 60, null);
				}
			}
			else if (count == 5) {
				g2.drawImage(safariBall, (20*6), 60, null);
			}
		}
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
				return new Pikachu();
			else if (num == 2)
				return new Paras();
			else if (num == 3)
				return new Exeggcute();
			else if (num == 4)
				return new Primeape();
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
			if (!drawing) { // disable button while drawing
				playSong(RUNAWAY);
				phase = 5;
				timer.start();
			}
			
		}

	}
	
	//Listener for throw a safari ball
	private class ThrowASafariBallListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (!drawing) { // disable button while drawing
				if (trainer.getItemNum(ItemType.SAFARI_BALL) == 0) {
					phase = 1;
					endOfBattle();
					mainFrame.outOfBalls();
				}
				trainer.useItem(ItemType.SAFARI_BALL);
				//throw a safari ball first
				phase = 4;
				timer.start();
				playSong(THROWBALL);
				
//				//TODO: check if pokemon is caught
//				if(encounter.isCaught()){
//					mainFrame.outOfBattle();
//					mainFrame.getBattleView().setVisible(false);
//					mainFrame.getMapView().setVisible(true);
//					mainFrame.mapSwitchUpdate();
//					mainFrame.setupItems();
//					playSong(POKECAUGHT);
//				}
			}
			
			
		}
		
	}
	
	//Listener for throw a rock
	private class ThrowARocklListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!drawing) { // disable button while drawing
				phase = 2;
				timer.start();
				encounter.throwRock();
				trainer.useItem(ItemType.ROCK);
				playSong(THROWROCK);
			}
		}
		
	}
	
	//Listener for throw a bait
	private class ThrowBaitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!drawing) { // disable button while drawing
				phase = 3;
				timer.start();
				encounter.throwBait();
				trainer.useItem(ItemType.BAIT);
				playSong(THROWBAIT);
			}
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
	
	// exit the battleview and set up the map view
	private void endOfBattle() {
		mainFrame.outOfBattle();
		mainFrame.getBattleView().setVisible(false);
		mainFrame.getMapView().setVisible(true);
		mainFrame.mapSwitchUpdate();
		mainFrame.setupItems();
		mainFrame.setUpMusic();
	}
	
	private class animationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			drawing = true;
			if (count < 5) {
				repaint();
				count++;
			} else {
				if (phase == 2 || phase == 3) {
					phase = encounter.performPokeAction();
				}
				else if (phase == 4) {
					if(encounter.isCaught()){
						phase = 10;
					} else {
						phase = 9;
					}
				}
				else if (phase == 5) {
					phase = 1;
					endOfBattle();
				} 
				else if (phase == 8) {
					phase = 1;
					endOfBattle();
				}
				else if (phase == 9) {
					phase = encounter.performPokeAction();
				}
				else if (phase == 10) {
					phase = 1;
					endOfBattle();
					playSong(POKECAUGHT);
				}
				else {
					phase = 1;
				}
				repaint();
				count = 0;
				timer.stop();
				if (phase > 5) {
					timer.start();
				}
				drawing = false;
				
			}
			
		}
		
	}

}
