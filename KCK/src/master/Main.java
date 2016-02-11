package master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        
    	Gram gram = new Gram();
    	gram.Gram();
    	
    	EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Projekt KCK");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new Pane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Pane extends JPanel {

        private int columnCount = 20;
        private int rowCount = 20;
        private List<Element> elements;
        private List<Rectangle> cells;
        private List<Rectangle> createdElements;

        public Pane() {
            cells = new ArrayList<>(columnCount * rowCount);
            
            elements = randomElements(10, 0, columnCount, 0, rowCount);
        }
        
        private boolean elementExists(int x, int y) {
        	boolean result = false;
        	
        	for(Element element : elements) {
        		if(element.x() == x && element.y() == y) {
        			result = true;
        			break;
        		}
        	}
        	
        	return result;
        }
        
        private List<Element> randomElements(int amount, int minX, int maxX, int minY, int maxY) {
        	elements = new ArrayList<Element>(amount);
        	createdElements = new ArrayList<Rectangle>(amount);
        	
        	while(amount > 0) {
        		int x = new Random().nextInt(maxX - minX);
        		int y = new Random().nextInt(maxY - minY);
        		
        		if(!elementExists(x, y)) {
        			elements.add(new Element(x, y));
        			
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
//            createdElements.clear();
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
                        Rectangle cell = new Rectangle(
                                xOffset + (col * cellWidth),
                                yOffset + (row * cellHeight),
                                cellWidth,
                                cellHeight);
                        cells.add(cell);
                        
                        if(elementExists(col, row)) {
                        	Rectangle element = new Rectangle(
                                    xOffset + (col * cellWidth) + (cellWidth / 4),
                                    yOffset + (row * cellHeight) + (cellHeight / 4),
                                    cellWidth / 2,
                                    cellHeight / 2);
                        	createdElements.add(element);
                        }
                    }
                }
            }

            g2d.setColor(Color.GRAY);
            for (Rectangle cell : cells) {
                g2d.draw(cell);
            }
            
            g2d.setPaint(Color.RED);
            for (Rectangle element : createdElements) {
                g2d.fill(element);
            }

            g2d.dispose();
        }
    }
}