package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Trainer;
import view.ItemView;
import view.MapView;

public class pokemonGUI extends JFrame {

	private static final long serialVersionUID = -2195306133576575637L;
	
	private JPanel currentView;
	private Trainer trainer;
	
	private MapView map;
	private ItemView items;
	
	// need to know the trainer
	public pokemonGUI(Trainer trainer) {
		this.trainer = trainer;
		// the map need to be set
		this.map = new MapView(trainer);
		setUpGameWindow();
	}

	private void setUpGameWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Zone");
		this.setSize(1000, 1000);
		this.setLocation(100, 100);
		currentView = map;
		
		
		this.setLayout(new GridLayout(1, 3));
		
		/*
		// map panel
		JPanel mapPanel = new JPanel();
		this.add(mapPanel);
		mapPanel.setBackground(Color.pink);
		
		// item panel
		JPanel itemsPanel = new JPanel();
		this.add(itemsPanel);
		itemsPanel.setBackground(Color.green);
		*/
		setupMenu();
		setupMap();
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
		this.setJMenuBar(menuBar);
	}
	
	private void setupMap(){
		map = new MapView(trainer);
		this.add(map);
	}
	
	private void setupItems(){
		items = new ItemView(trainer);
		this.add(items);
		System.out.println("here");
	}
	
	
	
	
	private class SaveGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO save the game into a file
			// what need to be saved 
		}
		
	}
	
	private class BackPackWindow implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Open a window to show items
			
		}
		
	}
	
	private class MovePadListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent press) {
			// TODO Auto-generated method stub
			if(trainer.getStep() <= 0){
				JOptionPane.showMessageDialog(null, "You can not move! You lOSE!");
			}
			else{
				boolean move = false;
				//press "up"
				if(press.getKeyCode() == KeyEvent.VK_UP){
					move = trainer.move("up");
				} else if (press.getKeyCode() == KeyEvent.VK_DOWN) {
					move = trainer.move("down");
				} else if (press.getKeyCode() == KeyEvent.VK_RIGHT) {
					move = trainer.move("right");
				} else if (press.getKeyCode() == KeyEvent.VK_LEFT) {
					move = trainer.move("left");
				}
				
				//int x = trainer.getX();
				//int y = trainer.getY();
				
				
			}
		}

		//Not used
		@Override
		public void keyReleased(KeyEvent release) {
			// TODO Auto-generated method stub
			
		}

		//Not used
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}