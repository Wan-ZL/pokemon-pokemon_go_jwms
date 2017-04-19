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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Trainer;
import view.ItemView;
import view.MapView;

public class pokemonGUI extends JFrame {

	private static final long serialVersionUID = -2195306133576575637L;
	
	private MapView currentView;
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
		this.setSize((20*36)+300, 590);
		this.setLocation(100, 100);
		cp = getContentPane();
		currentView = map;
		currentView.setLocation(0, 0);
		currentView.setSize(map.getWidth(), map.getHeight());
		this.addKeyListener(new MoveListener());
		cp.setLayout(null);
		cp.add(currentView);
		setupMenu();
		setupItems();
	}
	
	public void update(){
		currentView.updatePanel();
		this.repaint();
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
		items.setLocation(map.getWidth(), 0);
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
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(trainer.getStep() <= 0){
				JOptionPane.showMessageDialog(null, "You can not move! You lOSE!");
			}
			else{
				boolean move = false;
				int x = trainer.getX();
				int y = trainer.getY();
				int mapNum = trainer.getMap();
				String[][] theMap = map.getMap();
				String face = trainer.getTrainerDirection();
				//press "up"
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
					if(theMap[x][y+1] == "t" || theMap[x][y+1] == "a"){
						System.out.print("can't move");
					}
//					else if(theMap[x][y+1] == "n" || theMap[x][y+1] == "s"){
//						trainer.setPosition(x, y);
//					}
					else if(theMap[x][y+1] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y);
					}
					else if(theMap[x][y+1] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y);
					}
					else{
						trainer.setPosition(x, y+1);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if(theMap[x][y-1] == "t" || theMap[x][y-1] == "a"){
						System.out.print("can't move");
					}
//					else if(theMap[x][y-1] == "n" || theMap[x][y-1] == "s"){
//						trainer.setPosition(x, y);
//					}
					else if(theMap[x][y-1] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y);
					}
					else if(theMap[x][y-1] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y);
					}
					else{
						trainer.setPosition(x, y-1);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(theMap[x+1][y] == "t" || theMap[x+1][y] == "a"){
						System.out.print("can't move");
					}
//					else if(theMap[x+1][y] == "n" || theMap[x+1][y] == "s"){
//						trainer.setPosition(x, y);
//					}
					else if(theMap[x+1][y] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y);
					}
					else if(theMap[x+1][y] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y);
					}
					else{
						trainer.setPosition(x+1, y);
					}
				} 
				else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if(theMap[x-1][y] == "t" || theMap[x-1][y] == "a"){
						System.out.print("can't move");
					}
//					else if(theMap[x-1][y] == "n" || theMap[x-1][y] == "s"){
//						trainer.setPosition(x, y);
//					}
					else if(theMap[x-1][y] == "w"){
						System.out.print("Walk into water now");
						trainer.setPosition(x, y);
					}
					else if(theMap[x-1][y] == "g"){
						System.out.print("Walk into grass now");
						trainer.setPosition(x, y);
					}
					else{
						trainer.setPosition(x-1, y);
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