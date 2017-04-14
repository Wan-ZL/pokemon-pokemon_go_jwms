package controller;

import javax.swing.JFrame;

import model.Trainer;
import view.MapView;

public class pokemonGUI extends JFrame{

	private static final long serialVersionUID = -2195306133576575637L;
	
	private Trainer trainer;
	private MapView map;
	
	public pokemonGUI(Trainer trainer) {
		this.trainer = trainer;
	}

}