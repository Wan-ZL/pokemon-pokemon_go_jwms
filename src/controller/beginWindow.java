package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import view.LoadingView;

public class beginWindow extends JFrame{
	
	private LoadingView panel;
	private static final String BGM = Paths.get("sounds/BearDown.mp3").toUri().toString();
	private MediaPlayer mediaPlayer;
	
	public beginWindow(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pokemon Safari Login");
		JFXPanel fxPanel = new JFXPanel();
		this.setSize((20 * 11) + 230, (20 * 11) + 100);
		this.setLocation(100, 100);
		panel = new LoadingView(this);
		panel.setSize((20 * 11) + 230, (20 * 11) + 70);
		playSong(this.BGM);
		this.add(panel);
	}
	
	public MediaPlayer getMedia(){
		return this.mediaPlayer;
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
