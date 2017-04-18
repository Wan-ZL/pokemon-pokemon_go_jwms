package controller;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Trainer;
import view.ItemView;
import view.MapView;

public class pokemonGUI extends JFrame {

	private static final long serialVersionUID = -2195306133576575637L;
	
	private JPanel currentView;
	private Trainer trainer;
	private MapView map;
	private Container cp;
	private ItemView items;
	
	public pokemonGUI(Trainer trainer) {
		this.trainer = trainer;
		this.map = new MapView();
		setUpGameWindow();
	}

	private void setUpGameWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Zone");
		this.setSize(738, 590);
		this.setLocation(100, 100);
		cp = getContentPane();
		currentView = map;
		currentView.addKeyListener(new MoveListener());
		cp.setLayout(new GridLayout());
		cp.add(currentView);
		setupMenu();
		setupItems();
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
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}
	
	private void setupItems(){
		items = new ItemView(trainer);
		cp.add(items);
		//System.out.println("here");
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
	
	private class MoveListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			//if (e.getKeyCode())
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}