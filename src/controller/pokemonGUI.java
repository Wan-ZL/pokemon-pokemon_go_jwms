package controller;



import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectOutputStream;



import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import javax.swing.JPanel;



import model.Map;

import model.Trainer;

import view.ItemView;

import view.MapView;



public class pokemonGUI extends JFrame {



	private static final long serialVersionUID = -2195306133576575637L;

	private MapView currentView;
	private Trainer trainer;
	private MapView mapView;
	private Container cp;
	private ItemView items;
	private Map map;

	public pokemonGUI(Trainer trainer) {
		this.map = new Map();
		this.trainer = trainer;
		this.mapView = new MapView(trainer);
		setUpGameWindow();
	}

	private void setUpGameWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Zone");
		this.setSize((20*11)+200, (20*11)+62);
		this.setLocation(100, 100);
		cp = getContentPane();
		currentView = mapView;
		currentView.setLocation(0, 0);
		currentView.setSize(11*20, 11*20);
		this.addKeyListener(new MoveListener());
		cp.setLayout(null);
		cp.add(currentView);
		setupMenu();
		setupItems();
	}
	
	public void update(){
		currentView.updatePanel();
		//this.repaint();
	}

	private void setupMenu() {
		JMenu menu = new JMenu("Menu");
		JMenuItem save = new JMenuItem("Save");
		menu.add(save);
		save.addActionListener(new SaveGame());
		JMenuItem quit = new JMenuItem("Save and Quit");
		menu.add(quit);
		quit.addActionListener(new SaveGame());
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
	}

	

	private void setupItems(){
		items = new ItemView(trainer);
		items.setLocation((11*20), 0);
		cp.add(items);
		//System.out.println("here");
	}
	
	private class SaveGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int userInput = JOptionPane.showConfirmDialog(null, "Save over existing file?");
			if (userInput == JOptionPane.YES_OPTION) {
				
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream("saveData");
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
				ObjectOutputStream oos = null;
				try {
					oos = new ObjectOutputStream(fos);
					oos.writeObject(trainer);
					fos.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				if (e.getActionCommand() == "Save and Quit") {
					System.exit(DO_NOTHING_ON_CLOSE);
				}
				
			}
		}
		
	}
	
	private class MoveListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(trainer.getStep() <= 0){
				JOptionPane.showMessageDialog(null, "You can not move! You lOSE!");
			}
			else if (!trainer.MoveChanged()) {
				//boolean move = false;
				int x = trainer.getX();
				int y = trainer.getY();
				int mapNum = trainer.getMap();
				String[][] theMap = map.getMap(mapNum);
				String face = trainer.getTrainerDirection();
				
				//press "up"
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					trainer.setTrainerDirection("down");
					if(theMap[y+1][x] == "t" || theMap[y+1][x] == "a" || theMap[y+1][x] == "w" || theMap[y+1][x] == "i" || theMap[y+1][x] == "_"){
						System.out.print("can't move because of " + theMap[y+1][x]);
					}
//					else if(theMap[x][y+1] == "n" || theMap[x][y+1] == "s"){
//						trainer.setPosition(x, y);
//					}
					/*else if(theMap[y+1][x] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y+1);
						trainer.setChangedMove(true);
					}*/
					else if(theMap[y+1][x] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y+1);
						trainer.setChangedMove(true);
					}
					else{
						trainer.setPosition(x, y+1);
						trainer.setChangedMove(true);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					trainer.setTrainerDirection("up");
					if(theMap[y-1][x] == "t" || theMap[y-1][x] == "a" || theMap[y-1][x] == "w" || theMap[y-1][x] == "i" || theMap[y-1][x] == "_"){
						System.out.print("can't move because of " + theMap[y-1][x]);
					}
//					else if(theMap[x][y-1] == "n" || theMap[x][y-1] == "s"){
//						trainer.setPosition(x, y);
//					}
					/*else if(theMap[y-1][x] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y-1);
						trainer.setChangedMove(true);
					}*/
					else if(theMap[y-1][x] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y-1);
						trainer.setChangedMove(true);
					}
					else{
						trainer.setPosition(x, y-1);
						trainer.setChangedMove(true);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					trainer.setTrainerDirection("right");
					if(theMap[y][x+1] == "t" || theMap[y][x+1] == "a" || theMap[y][x+1] == "w" || theMap[y][x+1] == "i" || theMap[y][x+1] == "_"){
						System.out.print("can't move because of " + theMap[y][x+1]);
					}
//					else if(theMap[x+1][y] == "n" || theMap[x+1][y] == "s"){
//						trainer.setPosition(x, y);
//					}
					/*else if(theMap[y][x+1] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x+1, y);
						trainer.setChangedMove(true);
					}*/
					else if(theMap[y][x+1] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x+1, y);
						trainer.setChangedMove(true);
					}
					else{
						trainer.setPosition(x+1, y);
						trainer.setChangedMove(true);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					trainer.setTrainerDirection("left");
					if(theMap[y][x-1] == "t" || theMap[y][x-1] == "a" || theMap[y][x-1] == "w" || theMap[y][x-1] == "i" || theMap[y][x-1] == "_"){
						System.out.print("can't move because of " + theMap[y][x-1]);
					}
//					else if(theMap[x-1][y] == "n" || theMap[x-1][y] == "s"){
//						trainer.setPosition(x, y);
//					}
					/*else if(theMap[y][x-1] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x-1, y);
						trainer.setChangedMove(true);
					}*/
					else if(theMap[y][x-1] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x-1, y);
						trainer.setChangedMove(true);
					}
					else{
						trainer.setPosition(x-1, y);
						trainer.setChangedMove(true);
					}
				}
				System.out.println("x: "+trainer.getX()+", y: "+trainer.getY());
				update();
				
				//int x = trainer.getX();
				//int y = trainer.getY();	
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}

}