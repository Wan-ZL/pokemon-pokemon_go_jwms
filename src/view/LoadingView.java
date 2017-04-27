package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class StartScreenView will show the Start screen.
 */
public class LoadingView extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6718070001504906800L;

	/** The start screen image. */
	private Image startScreen;

	/**
	 * Instantiates a new start screen view.
	 */
	public LoadingView() {
		// read image
		try {
			startScreen = ImageIO.read(new File("image/BG.png"));
		} catch (IOException e) {
			System.out.println("Can not read pictures, please check pictures.");
		}
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		// paint the image
		graphics2d.drawImage(startScreen, 0, 0, null);
	}
}
