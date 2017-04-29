package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.LoadingView;

public class beginWindow extends JFrame{
	
	private LoadingView panel;
	
	public beginWindow(){
		this.setSize((20 * 11) + 230, (20 * 11) + 70);
		this.setLocation(100, 100);
		panel = new LoadingView(this);
		panel.setSize((20 * 11) + 230, (20 * 11) + 70);
		this.add(panel);
	}

	
}
