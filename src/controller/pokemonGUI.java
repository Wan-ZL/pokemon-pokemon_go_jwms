package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Trainer;
import view.MapView;

public class pokemonGUI extends JFrame {

	private static final long serialVersionUID = -2195306133576575637L;
	
	private JPanel currentView;
	private Trainer trainer;
	private MapView map;
	
	public pokemonGUI(Trainer trainer) {
		this.trainer = trainer;
		this.map = new MapView(trainer);
		setUpGameWindow();
	}

	private void setUpGameWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Zone");
		this.setSize(1000, 1000);
		this.setLocation(100, 100);
		this.setLayout(null);
		currentView = map;
		setupMenu();
	}

	private void setupMenu() {
		JMenu menu = new JMenu("Menu");
		JMenuItem save = new JMenuItem("Save");
		menu.add(save);
		save.addActionListener(new SaveGame());
		JMenuItem pack = new JMenuItem("Pack");
		menu.add(pack);
		save.addActionListener(new BackPackWindow());
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
	}
	
	private class SaveGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO save the game into a file
			
		}
		
	}
	
	private class BackPackWindow implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Open a window to show items
			
		}
		
	}
}