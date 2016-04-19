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

import javax.imageio.ImageIO;
import javax.swing.JPanel; 

public class Game extends JPanel {
	public int columnCount = 10;
	public int rowCount = 10;
	
	private List<Rectangle> cells;
	
	private List<Element> elements;
	private List<Rectangle> createdElements;
	
	public static Player player;
	private Rectangle createdPlayer;
	
	public Game(int x, int y, int direction) {
		this.cells = new ArrayList<>(this.columnCount * this.rowCount);
		
		this.elements = new ArrayList<Element>(10);
		this.createdElements = new ArrayList<Rectangle>(10);
		
		this.elements.add(new Element(1, 4, "hospital"));
		this.elements.add(new Element(1, 7, "mosque"));
		this.elements.add(new Element(2, 2, "castle"));
		this.elements.add(new Element(2, 6, "church"));
		this.elements.add(new Element(5, 2, "monument"));
		this.elements.add(new Element(5, 8, "restaurant"));
		this.elements.add(new Element(6, 5, "townhall"));
		this.elements.add(new Element(8, 0, "park"));
		this.elements.add(new Element(8, 6, "school"));
		this.elements.add(new Element(9, 3, "baker"));

		player = new Player(x, y, direction);
	}

	public boolean elementExists(int x, int y) {
		boolean result = false;
		
		for (Element element : this.elements) {
			if (element.x() == x && element.y() == y) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	public boolean playerExists(int x, int y) {
		if (player.x() == x && player.y() == y) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 800);
	}
	
	@Override
	public void invalidate() {
		this.cells.clear();
		this.createdElements.clear();
		
		super.invalidate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		int width = getWidth();
		int height = getHeight();
		
		int cellWidth = width / this.columnCount;
		int cellHeight = height / this.rowCount;
		
		int xOffset = (width - (this.columnCount * cellWidth)) / 2;
		int yOffset = (height - (this.rowCount * cellHeight)) / 2;
		
		if (this.cells.isEmpty()) {
			for (int row = 0; row < this.rowCount; row++) {
				for (int col = 0; col < this.columnCount; col++) {
					Rectangle cell = new Rectangle(xOffset + (col * cellWidth), yOffset + (row * cellHeight), cellWidth, cellHeight);
					this.cells.add(cell);
					
					if (elementExists(col, row)) {
						Rectangle element = new Rectangle(xOffset + (col * cellWidth) + (cellWidth / 4), yOffset + (row * cellHeight) + (cellHeight / 4), cellWidth / 2, cellHeight / 2);
						this.createdElements.add(element);
					}
					
					if (playerExists(col, row)) {
						this.createdPlayer = new Rectangle(xOffset + (col * cellWidth) + (cellWidth / 4), yOffset + (row * cellHeight) + (cellHeight / 4), cellWidth / 2, cellHeight / 2);
					}
				}
			}
		}
		
		g2d.setColor(Color.GRAY);
		for (Rectangle cell : this.cells) {
			g2d.draw(cell);
		}
		
		int i = 0;
		
		for (Rectangle element : this.createdElements) {
			BufferedImage image = null;
			
			try {
				image = ImageIO.read(new File("images/" + elements.get(i).type() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			TexturePaint texture = new TexturePaint(image, element);
			
			g2d.setPaint(texture);
			g2d.fill(element);
			
			i++;
		}
		
		g2d.setPaint(Color.GREEN);
		g2d.fill(this.createdPlayer);

		g2d.dispose();
	}	
}