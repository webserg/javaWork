package thread.exercises.goteborg.ball.init;

import java.awt.*;

/**
 * Created by webserg on 05.05.2014.
 */
public interface BallI extends Runnable {
    void move();

    //
    // SYNC: This modifies xpos and ypos.
    //
    void doMove();

    //
    // SYNC: This is accessed from the GUI thread, and
    //       it reads xpos and ypos.
    //
    void draw(Graphics g);
}
