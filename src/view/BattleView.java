package view;

import javax.swing.JPanel;

import model.Trainer;

public class BattleView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4796227636732972155L;

	private Trainer trainer;
	
	public BattleView(Trainer trainer) {
		this.trainer = trainer;
	}
}
