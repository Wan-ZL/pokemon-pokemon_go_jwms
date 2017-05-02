package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SplashScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.beginWindow;
import controller.pokemonGUI;
import javafx.scene.media.MediaPlayer;
import model.Trainer;


/**
 * The Class StartScreenView will show the Start screen.
 */
public class LoadingView extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6718070001504906800L;

	/** The start screen image. */
	private Image startScreen;
	private beginWindow beginFrame;
	private Trainer trainer;
	private JButton newGame;
	private JButton continueGame;
	private JTextField enterName;
	
	private final SplashScreen splash = SplashScreen.getSplashScreen();
	private Rectangle splashBounds;
	private Graphics2D splashGraphics;
	
	/**
	 * Instantiates a new start screen view.
	 */
	public LoadingView(beginWindow beginFrame) {
		//this.loadApplication();
		this.beginFrame = beginFrame;
		// read image
		try {
			startScreen = ImageIO.read(new File("image/BG.png"));
		} catch (IOException e) {
			System.out.println("Can not read pictures, please check pictures.");
		}
		addButton();
		repaint();
	}
	
	public void removeBeginFrame(){
		beginFrame.setVisible(false);
	}
	
	public void enterName(){
		this.newGame.setVisible(false);
		this.continueGame.setVisible(false);
		//this.repaint();
		this.enterName = new JTextField();
		this.enterName.setPreferredSize(new Dimension(100, 20));
		this.add(this.enterName);
		JButton setNameButton  = new JButton("Enter Trainer's Name");
		setNameButton.setSize(20, 20);
		setNameButton.addActionListener(new setNameButtonListener());
		this.add(setNameButton);
		
	}
	
	public void addButton(){
		this.newGame = new JButton("New Game");
		this.newGame.setSize(20, 20);
		//newGame.setLocation(20, 20);
		this.newGame.addActionListener(new newGameListener());
		this.add(this.newGame);
		this.continueGame = new JButton("Continue");
		this.continueGame.setSize(20, 20);
		this.continueGame.addActionListener(new continueGameLisener());
		this.add(this.continueGame);
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
		this.startScreen = this.startScreen.getScaledInstance((20 * 11) + 230, (20 * 11) + 70, Image.SCALE_SMOOTH);
		graphics2d.drawImage(startScreen, 0, 0, null);
	}
	
	public class setNameButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MediaPlayer mediaPlayer = beginFrame.getMedia();
			mediaPlayer.stop();
			mediaPlayer.dispose();
			trainer = Trainer.getTrainerInstance();
			trainer.setName(enterName.getText());
			pokemonGUI g = new pokemonGUI(trainer);
			g.setFocusable(true);
			g.requestFocusInWindow();
			g.setLocation(beginFrame.getLocation());
			g.setVisible(true);
			removeBeginFrame();
		}
		
	}
	
	public class newGameListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enterName();
		}
	}
	
	public class continueGameLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
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
			MediaPlayer mediaPlayer = beginFrame.getMedia();
			mediaPlayer.stop();
			mediaPlayer.dispose();
			pokemonGUI g = new pokemonGUI(trainer);
			g.setFocusable(true);
			g.requestFocusInWindow();
			g.setLocation(beginFrame.getLocation());
			g.setVisible(true);
			removeBeginFrame();
		}
		
	}
	
	/*protected void updateSplash(String status, int progress) {  
        if (splash == null || splashGraphics == null) {  
            return;  
        }  
        drawSplash(splashGraphics, status, progress);  
        splash.update();  
    }  
  
    *//** 
     * draw a bar
     *//*  
    protected void drawSplash(Graphics2D splashGraphics, String status, int progress) {  
        int barWidth = splashBounds.width;//bar length  
        splashGraphics.setComposite(AlphaComposite.Clear);  
        splashGraphics.fillRect(1, 10, splashBounds.width - 2, 20);//splash bound  
        splashGraphics.setPaintMode();//model  
        splashGraphics.setColor(Color.ORANGE);  
        splashGraphics.drawString(status, 10, 20);  
        splashGraphics.setColor(Color.red);  
        int width = progress * barWidth / 100; 
        splashGraphics.fillRect(0, splashBounds.height - 20, width, 6);  
    }  
  
    protected void initSplash() {  
        if (splash != null) {  
            splashBounds = splash.getBounds();  
            splashGraphics = (Graphics2D) splash.createGraphics();  
            if (splashGraphics != null) {  
                splashGraphics.setColor(Color.BLUE);  
                splashGraphics.drawRect(0, 0, splashBounds.width - 1, splashBounds.height - 1);  
            }  
        }  
    }  
    
    *//** 
     * load
     *//*  
    protected void loadApplication() {  
        initSplash();  
        final String[] stages = {"Starting", "Reading data", "Loading", "Done"};  
        int stage = 0;  
        //update splash
        for (int i = 0; i <= 100; i += 1) {  
            String status = stages[stage];  
            if (splash != null) {   
                updateSplash(status, i);  
            }  
            if (i == 30) {  
                stage = 1;  
            } else if (i == 70) {  
                stage = 2;  
            } else if (i == 90) {  
                stage = 3;  
            }  
            try {  
                //sleep for a while
                Thread.sleep(20);  
            } catch (Exception e) {  
            }  
        }  
        try {  
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        } catch (Exception e) {  
        }  
        beginWindow window = new beginWindow();  
        if (splash != null) {  
            splash.close();  
        }  
        window.setVisible(true);  
    }  */
}
