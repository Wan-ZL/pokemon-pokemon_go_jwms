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
import java.nio.file.Paths;

import javax.swing.JFrame;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Map;
import model.Pokemon;
import model.Trainer;
import model.items.ItemType;
import model.items.SafariBall;
import view.BattleView;
import view.ItemView;
import view.LoadingView;
import view.MapView;

public class pokemonGUI extends JFrame {

	private static final long serialVersionUID = -2195306133576575637L;
	private pokemonGUI mainFrame;
	private MapView currentView;
	private Trainer trainer;
	private MapView mapView;
	private Container cp;
	private ItemView items;
	private Map map;
	private BattleView battleview;
	private LoadingView loadingview;
	private JFXPanel fxPanel;
	private MediaPlayer mediaPlayer;
	private static final String BATTLESONG = Paths.get("sounds/battlemus.mp3").toUri().toString();
	private static final String BGM = Paths.get("sounds/bgm.mp3").toUri().toString();
	private boolean inMap;
	private boolean inBattle;

	public pokemonGUI(Trainer trainer) {
		JFXPanel fxPanel = new JFXPanel();
		this.mainFrame = this;
		this.map = new Map();
		this.trainer = trainer;
		this.mapView = new MapView(trainer);
		setUpGameWindow();
	}

	private void setUpGameWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Zone");
		this.setSize((20 * 11) + 230, (20 * 11) + 60);
		this.setLocation(100, 100);
		this.inMap = true;
		this.inBattle = false;
		// playSong(BGM);*/
		setBGM();
		cp = getContentPane();
		currentView = mapView;
		currentView.setLocation(0, 0);
		currentView.setSize(11 * 20, 11 * 20);
		this.addKeyListener(new MoveListener());
		// cp.add(loadingview);
		cp.setLayout(null);
		cp.add(currentView);
		setupMenu();
		setupItems();
	}

	public void setBGM() {
		if (inMap) {
			playSong(BGM);
		} else {
			playSong(BATTLESONG);
		}
	}

	public void update() {
		currentView.updatePanel();
		// battleview.updatePanel();
		items.updateSteps();
		items.updateTable();
		// this.repaint();
	}

	public void outOfBattle() {
		this.trainer.outOfBattle();
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

	public void redraw() {
		battleview.updatePanel();
	}

	public void mapSwitchUpdate() {
		cp.remove(currentView);
		currentView = new MapView(trainer);
		currentView.setLocation(0, 0);
		currentView.setSize(11 * 20, 11 * 20);
		cp.add(currentView);
		this.repaint();
	}

	public void setupItems() {
		items = new ItemView(trainer);
		items.setLocation((11 * 20), 0);
		cp.add(items);
		// System.out.println("here");
	}

	public BattleView getBattleView() {
		return battleview;
	}

	public MapView getMapView() {
		return currentView;
	}

	private class SaveGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!trainer.isInBattle()) {
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

	}

	private class MoveListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (!trainer.isInBattle()) {
				if (trainer.getStep() <= 0) {
					JOptionPane.showMessageDialog(null,
							"Out of steps! You caught " + trainer.getPokemonBelt().getSize() + " Pokemon!");
				} else if (!trainer.MoveChanged()) {
					// boolean move = false;
					int x = trainer.getX();
					int y = trainer.getY();
					int mapNum = trainer.getMapNum();
					String[][] theMap = map.getMap(mapNum);
					String face = trainer.getTrainerDirection();

					// press "up"
					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						trainer.setTrainerDirection("down");
						if (theMap[y + 1][x] == "t" || theMap[y + 1][x] == "a" || theMap[y + 1][x] == "w"
								|| theMap[y + 1][x] == "i" || theMap[y + 1][x] == "_") {
							System.out.print("can't move because of " + theMap[y + 1][x]);
						} else if (theMap[y + 1][x] == "g") {
							System.out.print("Walk into grass now");
							trainer.setPosition(x, y + 1);
							trainer.setChangedMove(true);
						} else if (theMap[y + 1][x] == "p") {
							trainer.setPosition(x, y + 1);
							trainer.setChangedMove(true);
							System.out.print("You find a safari ball!!");
							JOptionPane.showMessageDialog(null, "You find a safari ball!!");
							trainer.getBackpack().addItem(new SafariBall(1));
							//update();
						}else if (theMap[y + 1][x] == "r"){ 
							trainer.setPosition(x, y+1);
							trainer.setChangedMove(true);
							int userInput = JOptionPane.showConfirmDialog(null, "You find a treasure box!! want to open it??");
							if(userInput == JOptionPane.YES_OPTION){
								//TODO: do something and set the image back
							}
							else{
								//TODO: set the image back
							}
						}
						else {
							trainer.setPosition(x, y + 1);
							trainer.setChangedMove(true);
						}
					}

					else if (e.getKeyCode() == KeyEvent.VK_UP) {
						trainer.setTrainerDirection("up");
						if (theMap[y - 1][x] == "t" || theMap[y - 1][x] == "a" || theMap[y - 1][x] == "w"
								|| theMap[y - 1][x] == "i" || theMap[y - 1][x] == "_") {
							System.out.print("can't move because of " + theMap[y - 1][x]);
						} else if (theMap[y - 1][x] == "g") {
							System.out.print("Walk into grass now");
							trainer.setPosition(x, y - 1);
							trainer.setChangedMove(true);
						} else if (theMap[y - 1][x] == "p") {
							trainer.setPosition(x, y - 1);
							trainer.setChangedMove(true);
							JOptionPane.showMessageDialog(null, "You find a safari ball!!");
							trainer.getBackpack().addItem(new SafariBall(1));
							//update();
						}else if (theMap[y - 1][x] == "r"){ 
							trainer.setPosition(x, y-1);
							trainer.setChangedMove(true);
							int userInput = JOptionPane.showConfirmDialog(null, "You find a treasure box!! want to open it??");
							if(userInput == JOptionPane.YES_OPTION){
								//TODO: do something and set the image back
							}
							else{
								//TODO: set the image back
							}
						}
						else {
							trainer.setPosition(x, y - 1);
							trainer.setChangedMove(true);
						}
					}

					else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						trainer.setTrainerDirection("right");
						if (theMap[y][x + 1] == "t" || theMap[y][x + 1] == "a" || theMap[y][x + 1] == "w"
								|| theMap[y][x + 1] == "i" || theMap[y][x + 1] == "_") {
							System.out.print("can't move because of " + theMap[y][x + 1]);
						} else if (theMap[y][x + 1] == "g") {
							System.out.print("Walk into grass now");
							trainer.setPosition(x + 1, y);
							trainer.setChangedMove(true);
						} else if (theMap[y][x + 1] == "p") {
							// System.out.print("Walk into grass now");
							trainer.setPosition(x + 1, y);
							trainer.setChangedMove(true);
							JOptionPane.showMessageDialog(null, "You find a safari ball!!");
							trainer.getBackpack().addItem(new SafariBall(1));
							//update();
						} else if (theMap[y][x + 1] == "r"){
							trainer.setPosition(x + 1, y);
							trainer.setChangedMove(true);
							int userInput = JOptionPane.showConfirmDialog(null, "You find a treasure box!! want to open it??");
							if(userInput == JOptionPane.YES_OPTION){
								//TODO: do something and set the image back
							}
							else{
								//TODO: set the image back
							}
						}
						else {
							trainer.setPosition(x + 1, y);
							trainer.setChangedMove(true);
						}
					}

					else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						trainer.setTrainerDirection("left");
						if (theMap[y][x - 1] == "t" || theMap[y][x - 1] == "a" || theMap[y][x - 1] == "w"
								|| theMap[y][x - 1] == "i" || theMap[y][x - 1] == "_") {
							System.out.print("can't move because of " + theMap[y][x - 1]);
						} else if (theMap[y][x - 1] == "g") {
							System.out.print("Walk into grass now");
							trainer.setPosition(x - 1, y);
							trainer.setChangedMove(true);
						} else if (theMap[y][x - 1] == "p") {
							trainer.setPosition(x - 1, y);
							trainer.setChangedMove(true);
							JOptionPane.showMessageDialog(null, "You find a safari ball!!");
							trainer.getBackpack().addItem(new SafariBall(1));
							//update();
						}else if (theMap[y][x - 1] == "r") {
							trainer.setPosition(x - 1, y);
							trainer.setChangedMove(true);
							int userInput = JOptionPane.showConfirmDialog(null, "You find a treasure box!! want to open it??");
							if(userInput == JOptionPane.YES_OPTION){
								//TODO: do something and set the image back
							}
							else{
								//TODO: set the image back
							}
						}  
						else {
							trainer.setPosition(x - 1, y);
							trainer.setChangedMove(true);
						}
					}
					System.out.println("x is " + trainer.getX() + ", y is " + trainer.getY());
					update();

					// int x = trainer.getX();
					// int y = trainer.getY();
					if (trainer.getItemNum(ItemType.SAFARI_BALL) != 0) {
						if (trainer.meetPokemon()) {
							System.out.println("going to battle");
							cp.remove(items);
							//
							cp.remove(currentView);
							/*
							 * try{ Thread.sleep(200); }catch(Exception e1){
							 * 
							 * }
							 */
							cp.add(battleview = new BattleView(trainer, mainFrame));
							// playSong(BATTLESONG);
							inMap = false;
							inBattle = true;
							setBGM();
							battleview.setSize(battleview.getPreferredSize());
							battleview.setLocation(0, 0);
							battleview.setVisible(true);
							mapView.setVisible(false);
							redraw();
						}
					}
				}
				/*
				 * //System.out.println(theMap[trainer.getY()][trainer.getX()]);
				 * update();
				 * 
				 * 
				 * //int x = trainer.getX(); //int y = trainer.getY();
				 * if(trainer.getItemNum(ItemType.SAFARI_BALL) != 0){ Pokemon
				 * poke = trainer.meetPokemon(); if(poke != null){
				 * System.out.println(poke.getName()); cp.remove(items);
				 * cp.remove(currentView); cp.add(battleview = new
				 * BattleView(trainer));
				 * battleview.setSize(battleview.getPreferredSize());
				 * battleview.setLocation(0, 0); battleview.setVisible(true);
				 * mapView.setVisible(false); redraw(); } }
				 */

				if (trainer.getX() == 5) { // map change
					if (trainer.getY() == 17 || trainer.getY() == 18) {
						System.out.println("switch");
						trainer.setMapNum(2);
						trainer.setPosition(5, 27);
						trainer.setTrainerDirection("right");
						mapSwitchUpdate();
					} else {
						if (trainer.getY() == 26 || trainer.getY() == 27) {
							System.out.println("switch");
							trainer.setMapNum(1);
							trainer.setPosition(5, 18);
							trainer.setTrainerDirection("right");
							mapSwitchUpdate();
						}
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	}

	private void playSong(String location) {
		if (this.mediaPlayer != null) {
			this.mediaPlayer.stop();
			this.mediaPlayer.dispose();
		}
		Media song = new Media(location);
		this.mediaPlayer = new MediaPlayer(song);
		this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		this.mediaPlayer.play();
	}

}