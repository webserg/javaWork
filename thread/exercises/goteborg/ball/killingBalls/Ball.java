package thread.exercises.goteborg.ball.killingBalls;

import thread.exercises.goteborg.ball.init.BallI;
import thread.exercises.goteborg.ball.init.BallWorld;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ball extends Thread implements BallI {

    BallWorld<Ball> world;

    private int xpos, ypos, xinc, yinc;

    private final Color col;

    private final static int ballw = 10;
    private final static int ballh = 10;
    private final Semaphore live;
    private final Semaphore die;
    private final Random randomGenerator = new Random();

    public Ball(BallWorld<Ball> world, int xpos, int ypos,
                int xinc, int yinc, Color col,Semaphore live,Semaphore die) {
        //
        // Assign a name to this thread for easier debugging
        //
        super("Ball :" + col);

        this.world = world;
        this.xpos = xpos;
        this.ypos = ypos;
        this.xinc = xinc;
        this.yinc = yinc;
        this.col = col;
        this.live = live;
        this.die = die;

        world.addBall(this);
    }

    public void run(){
        try {
            live.acquire();
        }catch (InterruptedException e){}

        while (true) {
            move();
            if(randomGenerator.nextInt(4)==1 && die.tryAcquire()) break;
        }
        Balls.nap(30);
        world.removeBall(this);
        world.repaint();
        Balls.nap(30);
    }

    public void move() {
        if (xpos >= world.getWidth() - ballw || xpos <= 0) xinc = -xinc;

        if (ypos >= world.getHeight() - ballh || ypos <= 0) yinc = -yinc;

        Balls.nap(30);
        doMove();
        world.repaint();
    }

    //
    // SYNC: This modifies xpos and ypos.
    //
    public synchronized void doMove() {
        xpos += xinc;
        ypos += yinc;
    }

    //
    // SYNC: This is accessed from the GUI thread, and
    //       it reads xpos and ypos.
    //
    public synchronized void draw(Graphics g) {
        g.setColor(col);
        g.fillOval(xpos, ypos, ballw, ballh);
    }


}
