package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Trainer;
import view.LoadingView;

public class pokemonGO {
	// have a trainer instance
	private static Trainer trainer;
	private static LoadingView loadingview;

	public static void main(String[] args) {
		//setUpModel();
		beginWindow();
		/*loadingview = new LoadingView();
		loadingview.setBounds(0, 0, 1000, 570);
		loadingview.setFocusable(false);
		loadingview.setVisible(true);*/
		/*pokemonGUI g = new pokemonGUI(trainer);
		g.setFocusable(true);
		g.requestFocusInWindow();
		g.setVisible(true);*/
	}
	
	private static void beginWindow(){
		beginWindow g = new beginWindow();
		g.setVisible(true);
	}

	
	/*private static void setUpModel() {
		int userInput = JOptionPane.showConfirmDialog(null, "Continue from a saved game?");
		if (userInput == JOptionPane.YES_OPTION) {

			// Attempt to open a file stream from "saveData"
			FileInputStream fis = null;
			try {
				fis = new FileInputStream("saveData");
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(new JFrame(), "No save data found!");
			}

			// Attempt to open an Object stream from the file stream
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Attempt to load the trainer model
			try {
				trainer = (Trainer) ois.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}

			// Try to close the input stream
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// start from fresh
			trainer = Trainer.getTrainerInstance();
			String userName = JOptionPane.showInputDialog("Enter a your name.");
			trainer.setName(userName);
		}

	}
*/
}
