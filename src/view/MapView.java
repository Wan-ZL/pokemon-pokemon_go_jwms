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

public class MapView extends JPanel {

	private static final long serialVersionUID = 3336864412070556704L;

	private Map theMap;
	private int mapNum;
	private int height = 26;
	private int width = 36;
	private int trainerX;
	private int trainerY;

	// Images
	private Image grass, treasure, pokeball, RoadOne, RoadTwo, sand, water, tree, sign, RoughRoad, Rock, stairs,
			emptySquare;
	private BufferedImage trainerImg, forward, backward, left, right, forward_walking_left, forward_walking_right,
			backward_walking_left, backward_walking_right, left_walking_left, left_walking_right, right_walking_left,
			right_walking_right;

	/** The sprite size. */
	private final int spriteSize = 32;
	private Timer timer;
	private int count, xCount, yCount;

	private Trainer trainer;
	private String[][] map;

	public MapView(Trainer trainer) {
		this.trainer = trainer;
		this.trainerX = trainer.getX();
		// this is to get the Y axis for trainer
		this.trainerY = trainer.getY();
		this.theMap = new Map();
		this.mapNum = trainer.getMapNum();

		this.setSize(20 * 36, 26 * 20);

		try {
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
			emptySquare = ImageIO.read(new File("image/black.square.jpg"));
			pokeball = ImageIO.read(new File("image/pokeballsmallnew.png"));
			trainerImg = ImageIO.read(new File("image/TrainerMove.png"));
			treasure = ImageIO.read(new File("image/special.jpg"));

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
		} catch (IOException e) {
			System.out.println("Cannot find the image file.");
		}

		timer = new Timer(60, new TrainerListener());
		repaint();
	}

	public String[][] getMap() {
		return this.map;

	}

	public void update() {
		System.out.println("here");
	}

	public void updatePanel() {
		this.trainerX = trainer.getX();
		this.trainerY = trainer.getY();
		if (trainer.MoveChanged()) {
			count = 4;
			timer.start();
			trainer.setChangedDirection(false);
		} else {
			if (trainer.DirectionChanged()) {
				repaint();
				trainer.setChangedDirection(false);
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		int x = trainer.getX();
		int y = trainer.getY();
		for (int i = y - 5, r = 0; i <= y + 5; i++, r++) {
			for (int j = x - 5, c = 0; j <= x + 5; j++, c++) {
				String loc = theMap.getItemOnMap(mapNum, i, j);
				// Draw images by compare strings
				if (loc.equals("t")) {
					g2.drawImage(tree, c * 20, r * 20, null);
				} else if (loc.equals("g")) {
					g2.drawImage(grass, c * 20, r * 20, null);
				} else if (loc.equals("n")) {
					if (Math.random() * 10 < 5) {
						g2.drawImage(RoadOne, c * 20, r * 20, null);
					} else {
						g2.drawImage(RoadTwo, c * 20, r * 20, null);
					}
				} else if (loc.equals("s")) {
					g2.drawImage(sand, c * 20, r * 20, null);
				} else if (loc.equals("w")) {
					g2.drawImage(water, c * 20, r * 20, null);
				} else if (loc.equals("i")) {
					g2.drawImage(sign, c * 20, r * 20, null);
				} else if (loc.equals("a")) {
					g2.drawImage(Rock, c * 20, r * 20, null);
				} else if (loc.equals("l")) {
					g2.drawImage(stairs, c * 20, r * 20, null);
				} else if (loc.equals("b")) {
					g2.drawImage(RoughRoad, c * 20, r * 20, null);
				} else if (loc.equals("_")) {
					g2.drawImage(emptySquare, c * 20, r * 20, null);
				} else if (loc.equals("p")) {
					g2.drawImage(pokeball, c * 20, r * 20, null);
				} else if (loc.equals("r")) {
					g2.drawImage(treasure, c * 20, r * 20, null);
				}
			}
		}

		// if the trainer's direction is UP
		if (trainer.getTrainerDirection().equals("up")) {
			if (count > 0) {
				if (count % 2 == 1) {
					g2.drawImage(backward_walking_left, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				} else if (count % 2 == 0) {
					g2.drawImage(backward_walking_right, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				}
			} else {
				g2.drawImage(backward, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
			}
		}
		// if the trainer's direction is DOWN
		else if (trainer.getTrainerDirection().equals("down")) {
			if (count > 0) {
				if (count % 2 == 0) {
					g2.drawImage(forward_walking_left, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				} else if (count % 2 == 1) {
					g2.drawImage(forward_walking_right, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				}
			} else {
				g2.drawImage(forward, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
			}
		}
		// if the trainer's direction is RIGHT
		else if (trainer.getTrainerDirection().equals("right")) {
			if (count > 0) {
				if (count % 2 == 0) {
					g2.drawImage(right_walking_left, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				} else if (count % 2 == 1) {
					g2.drawImage(right_walking_right, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				}
			} else {
				g2.drawImage(right, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
			}
		}
		// if the trainer's direction is LEFT
		else {
			if (count > 0) {
				if (count % 2 == 1) {
					g2.drawImage(left_walking_left, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				} else if (count % 2 == 0) {
					g2.drawImage(left_walking_right, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
				}
			} else {
				g2.drawImage(left, 5 * 20 - 6 + xCount, 5 * 20 - 12 + yCount, null);
			}
		}
	}

	public int getMapWidth() {
		return 20 * 11;
	}

	public int getMapHeight() {
		return 20 * 11;
	}

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