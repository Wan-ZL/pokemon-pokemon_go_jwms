package view;

import java.awt.Dimension;
import java.util.Random;

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
	
	public BattleView(Trainer trainer) {
		this.trainer = trainer;
		encounter = new Encounter(getPokemon(), trainer);
		this.setPreferredSize(new Dimension(20*11, 20*11));
	}

	private Pokemon getPokemon() {
		// TODO get a random int to choose which pokemon to create for the
		//      encounter.
		return null;
	}
}
