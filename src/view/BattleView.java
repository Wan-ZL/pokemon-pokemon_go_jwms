package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	
	public BattleView(Trainer trainer) {
		this.trainer = trainer;
		encounter = new Encounter(getPokemon(), trainer);
		battlePan = new JPanel();
		this.setPreferredSize(new Dimension(20*11, 20*11));
		this.setLayout(null);
		throwASafariBall = new JButton("Throw A Safari Ball");
		throwARock = new JButton("Throw A Rock");
		runAway = new JButton("Run Away");
		ThrowABait = new JButton("Throw A Bait");
		
		TrainerHealth = new JTextArea("");
		PokemonHealth = new JTextArea("");
		
		TrainerHealth.setEditable(false);
		throwASafariBall.setBounds(370, 380, 150, 30);
		throwARock.setBounds(520, 380, 150, 30);
		runAway.setBounds(520, 420, 150, 30);
		ThrowABait.setBounds(370, 420, 150, 30);
		
		this.add(ThrowABait);
		this.add(runAway);
		this.add(throwARock);
		this.add(throwASafariBall);
		
		runAway.addActionListener(new RunAwayListener());
		throwARock.addActionListener(new ThrowARocklListener());
		throwASafariBall.addActionListener(new ThrowASafariBallListener());
		ThrowABait.addActionListener(new ThrowBaitListener());
		
		JScrollPane scroll = new JScrollPane(TrainerHealth);
		scroll.setBounds(50, 350, 300, 150);
		this.add(scroll);
		
		try {
			backGround = ImageIO.read(new File("image/battle_bg.jpg"));
		} catch (IOException e) {
			System.out.println("Cannot find the image file!");
			e.printStackTrace();
		}
		
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
		return null;
	}
	
	// Listener for run away
	private class RunAwayListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
	
	//Listener for throw a safari ball
	private class ThrowASafariBallListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//Listener for throw a rock
	private class ThrowARocklListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//Listener for throw a bait
	private class ThrowBaitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
