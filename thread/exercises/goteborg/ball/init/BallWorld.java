package thread.exercises.goteborg.ball.init;

import thread.exercises.goteborg.ball.killingBalls.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class BallWorld<T extends BallI> extends JPanel {

    private final int xSize = 250;
    private final int ySize = 250;

    private final static Color BGCOLOR = Color.white;

    private ArrayList<T> balls = new ArrayList<>();

    public BallWorld() {
        setPreferredSize(new Dimension(xSize,ySize));
	setOpaque(true);
	setBackground(BGCOLOR);
    }

    //
    // In order to access the balls collection only
    // from one thread, let it be modified inside
    // the GUI thread.
    //
    public void addBall(final T b) {
	SwingUtilities.invokeLater(new Runnable () {
		public void run() {
		    balls.add(b);
		    repaint();
	        }
	    });
    }
    public void removeBall(final T b) {
        SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                balls.remove(b);
                repaint();
            }
        });
    }

    //
    // This is run from the GUI thread and
    // reads the balls collection.
    //
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	for(T b : balls)
	    b.draw(g);
    }
}
