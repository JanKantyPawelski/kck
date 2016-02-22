package master;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel; 

public class Game extends JPanel {
	
	//konstruktor klasy Game, otwiera Panel
	
	public Game(){
		
		Panel();
	}

	private int columnCount = 10;
	private int rowCount = 10;
	private List<Element> elements;
	private Player player;
	private List<Rectangle> cells;
	private List<Rectangle> createdElements;
	private Rectangle createdPlayer;

	public void Panel() {
		cells = new ArrayList<>(columnCount * rowCount);

		// elements = randomElements(10, 0, columnCount, 0, rowCount);
		elements = new ArrayList<Element>(10);
		createdElements = new ArrayList<Rectangle>(10);
		
		elements.add(new Element(8, 0, "park"));
		elements.add(new Element(2, 2, "castle"));
		elements.add(new Element(5, 2, "monument"));
		elements.add(new Element(9, 3, "baker"));
		elements.add(new Element(1, 4, "hospital"));
		elements.add(new Element(6, 5, "townhall"));
		elements.add(new Element(2, 6, "church"));
		elements.add(new Element(8, 6, "school"));
		elements.add(new Element(1, 7, "mosque"));
		elements.add(new Element(5, 8, "restaurant"));
		
		player = new Player(4, 9);
	}

	private boolean elementExists(int x, int y) {
		boolean result = false;

		for (Element element : elements) {
			if (element.x() == x && element.y() == y) {
				result = true;
				break;
			}
		}

		return result;
	}
	
	private boolean playerExists(int x, int y) {
		if (player.x() == x && player.y() == y) {
			return true;
		}
		
		return false;
	}

	private List<Element> randomElements(int amount, int minX, int maxX, int minY, int maxY) {
		elements = new ArrayList<Element>(amount);
		createdElements = new ArrayList<Rectangle>(amount);

		while (amount > 0) {
			int x = new Random().nextInt(maxX - minX);
			int y = new Random().nextInt(maxY - minY);

			if (!elementExists(x, y)) {
				elements.add(new Element(x, y, "school"));

				amount--;
			}
		}

		return elements;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}

	@Override
	public void invalidate() {
		cells.clear();
		createdElements.clear();
		super.invalidate();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();

		int width = getWidth();
		int height = getHeight();

		int cellWidth = width / columnCount;
		int cellHeight = height / rowCount;

		int xOffset = (width - (columnCount * cellWidth)) / 2;
		int yOffset = (height - (rowCount * cellHeight)) / 2;

		if (cells.isEmpty()) {
			for (int row = 0; row < rowCount; row++) {
				for (int col = 0; col < columnCount; col++) {
					Rectangle cell = new Rectangle(xOffset + (col * cellWidth), yOffset + (row * cellHeight), cellWidth, cellHeight);
					cells.add(cell);

					if (elementExists(col, row)) {
						Rectangle element = new Rectangle(xOffset + (col * cellWidth) + (cellWidth / 4), yOffset + (row * cellHeight) + (cellHeight / 4), cellWidth / 2, cellHeight / 2);
						createdElements.add(element);
					}
					
					if (playerExists(col, row)) {
						createdPlayer = new Rectangle(xOffset + (col * cellWidth) + (cellWidth / 4), yOffset + (row * cellHeight) + (cellHeight / 4), cellWidth / 2, cellHeight / 2);
					}
				}
			}
		}

		g2d.setColor(Color.GRAY);
		for (Rectangle cell : cells) {
			g2d.draw(cell);
		}

		int i = 0;
		
		for (Rectangle element : createdElements) {
			BufferedImage image = null;
			
			System.out.println("images/" + elements.get(i).type() + ".png");
			
			try {
				image = ImageIO.read(new File("images/" + elements.get(i).type() + ".png"));
			}
			
			catch (IOException e) {
				e.printStackTrace();
			}
			
			TexturePaint texture = new TexturePaint(image, element);
			
			g2d.setPaint(texture);
			g2d.fill(element);
			
			i++;
		}
		
		g2d.setPaint(Color.GREEN);
		g2d.fill(createdPlayer);

		g2d.dispose();
	}
	
	
}
