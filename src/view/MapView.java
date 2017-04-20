package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Map;
import model.Trainer;

public class MapView extends JPanel{


	private static final long serialVersionUID = 3336864412070556704L;
	
	private Map theMap;
	private int mapNum;
	private int height = 26;
	private int width = 36;
	private int trainerX;
	private int trainerY;
	//Images
	private Image grass, RoadOne, RoadTwo, sand, water, tree, sign, RoughRoad, Rock, stairs;
	private BufferedImage trainerImg, forward, backward, left, right, forward_walking_left, forward_walking_right,
			backward_walking_left, backward_walking_right, left_walking_left, left_walking_right, right_walking_left,
			right_walking_right;

	/** The sprite size. */
	private final int spriteSize = 32;
	private Timer timer;
	private int count, xCount, yCount;
	
	private Trainer trainer;
	private String[][] map;

	public MapView(Trainer trainer){
		this.trainer = trainer;
		//this.data = control;
		//this is to get the X axis for trainer
		this.trainerX = trainer.getX();
		//this is to get the Y axis for trainer
		this.trainerY = trainer.getY();
		this.theMap = new Map();
		this.mapNum = trainer.getMapNum();
		
		this.setSize(20*36, 26*20);
		
		//TODO: set the images
		try{
			grass = ImageIO.read(new File("image/big bush.png"));
			RoadOne = ImageIO.read(new File("image/grassRoadBig.png"));
			RoadTwo = ImageIO.read(new File("image/grassRoadNew.png"));
			sand = ImageIO.read(new File("image/sandRoad.png"));
			water = ImageIO.read(new File("image/waterBig.png"));
			tree = ImageIO.read(new File("image/TreeBig.png"));
			sign = ImageIO.read(new File("image/SignBig.png"));
			RoughRoad = ImageIO.read(new File("image/RoughRoad.png"));
			Rock = ImageIO.read(new File("image/Rock.png"));
			stairs = ImageIO.read(new File("image/Stair.png"));

			trainerImg = ImageIO.read(new File("image/TrainerMove.png"));

			forward = trainerImg.getSubimage(0, 64, spriteSize, spriteSize);
			backward = trainerImg.getSubimage(0, 0, spriteSize, spriteSize);
			left = trainerImg.getSubimage(0, 32, spriteSize, spriteSize);
			right = trainerImg.getSubimage(0, 96, spriteSize, spriteSize);

			forward_walking_left = trainerImg.getSubimage(32, 64, spriteSize, spriteSize);
			forward_walking_right = trainerImg.getSubimage(64, 64, spriteSize, spriteSize);
			backward_walking_left = trainerImg.getSubimage(32, 0, spriteSize, spriteSize);
			backward_walking_right = trainerImg.getSubimage(64, 0, spriteSize, spriteSize);
			left_walking_left = trainerImg.getSubimage(32, 32, spriteSize, spriteSize);
			left_walking_right = trainerImg.getSubimage(64, 32, spriteSize, spriteSize);
			right_walking_left = trainerImg.getSubimage(32, 96, spriteSize, spriteSize);
			right_walking_right = trainerImg.getSubimage(64, 96, spriteSize, spriteSize);
		}catch(IOException e){
			System.out.println("Cannot find the image file.");
		}
		
		timer = new Timer(50, new TrainerListener());
		repaint();
	}
	
	public String[][] getMap(){
		return this.map;
		
	}
	
	public void update(){
		System.out.println("here");
	}
	
	public void updatePanel() {
		this.trainerX = trainer.getX();
		this.trainerY = trainer.getY();
		//TODO: I want to check if the trainer is walking around
		//		or just turn his face(change the direction) without
		//		move
		if(trainer.MoveChanged()){
			count = 4;
			timer.start();
			//trainer.setChangedMove(false);
			trainer.setChangedDirection(false);
		}
		else{
			if(trainer.DirectionChanged()){
				repaint();
				trainer.setChangedDirection(false);
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				//TODO: Data controller call getmap() to get the map, them get the location

				String loc = theMap.getItemOnMap(mapNum ,i, j);
				//Draw images by compare strings
				if (loc.equals("t")) {
					g2.drawImage(tree, j * 20, i * 20, null);
				} else if (loc.equals("g")) {
					g2.drawImage(grass, j * 20, i * 20, null);
				} else if (loc.equals("n")) {
					if (Math.random() * 10 < 5) {
						g2.drawImage(RoadOne, j * 20, i * 20, null);
					} else {
						g2.drawImage(RoadTwo, j * 20, i * 20, null);
					}
				} else if (loc.equals("s")) {
					g2.drawImage(sand, j * 20, i * 20, null);
				} else if (loc.equals("w")) {
					g2.drawImage(water, j * 20, i * 20, null);
				} else if (loc.equals("i")) {
					g2.drawImage(sign, j * 20, i * 20, null);
				} else if (loc.equals("a")) {
					g2.drawImage(Rock, j * 20, i * 20, null);
				} else if (loc.equals("l")) {
					g2.drawImage(stairs, j * 20, i * 20, null);
				} else if (loc.equals("b")) {
					g2.drawImage(RoughRoad, j * 20, i * 20, null);
				}
			}
		}
		
		//if the trainer's direction is UP
		if (trainer.getTrainerDirection().equals("up")) {
			if (count > 0) {
				if (count % 2 == 1) {
					g2.drawImage(backward_walking_left, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				} else if (count % 2 == 0) {
					g2.drawImage(backward_walking_right, trainerX * 20 - 6 + xCount,
							trainerY * 20 - 12 + yCount, null);
				}
			} else {
				g2.drawImage(backward, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount, null);
			}
		}
		//if the trainer's direction is DOWN
		else if (trainer.getTrainerDirection().equals("down")) {
			if (count > 0) {
				if (count % 2 == 0) {
					g2.drawImage(forward_walking_left, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				} else if (count % 2 == 1) {
					g2.drawImage(forward_walking_right, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				}
			} else {
				g2.drawImage(forward, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount, null);
			}
		}
		//if the trainer's direction is RIGHT
		else if (trainer.getTrainerDirection().equals("right")) {
			if (count > 0) {
				if (count % 2 == 0) {
					g2.drawImage(right_walking_left, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				} else if (count % 2 == 1) {
					g2.drawImage(right_walking_right, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				}
			} else {
				g2.drawImage(right, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount, null);
			}
		}
		//if the trainer's direction is LEFT
		else {
			if (count > 0) {
				if (count % 2 == 1) {
					g2.drawImage(left_walking_left, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				} else if (count % 2 == 0) {
					g2.drawImage(left_walking_right, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount,
							null);
				}
			} else {
				g2.drawImage(left, trainerX * 20 - 6 + xCount, trainerY * 20 - 12 + yCount, null);
			}
		}
	}
	
	public int getMapWidth() {
		return 20 * width;
	}
	
	public int getMapHeight() {
		return 20 * height;
	}
	
	/**
	 * The listener interface for receiving move events. The class that is
	 * interested in processing a move event implements this interface, and the
	 * object created with that class is registered with a component using the
	 * component's <code>addMoveListener<code> method. When the move event
	 * occurs, that object's appropriate method is invoked.
	 *
	 * @see MoveEvent
	 */
	public class TrainerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Trainer move animation
						if (count > 0) {
							if (trainer.getTrainerDirection().equals("up")) {
								xCount = 0;
								yCount = count * 5;
							} else if (trainer.getTrainerDirection().equals("down")) {
								xCount = 0;
								yCount = -count * 5;
							} else if (trainer.getTrainerDirection().equals("right")) {
								yCount = 0;
								xCount = -count * 5;
							} else {
								yCount = 0;
								xCount = count * 5;
							}
							if (count == 1) {
								trainer.setChangedMove(false);
							}
							
							repaint();
							count--;
						} else {
							xCount = 0;
							yCount = 0;
							count = 0;
							repaint();
							
							timer.stop();
							
						}
		}

	}
	
}
