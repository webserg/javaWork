package thread.exercises.goteborg.ball.freezingBallsCyclicBarrierOwn;

/**
 * Created by webserg on 05.05.2014.
 */
public class MyCyclicBarrier2 {
    int counter;
    int p;

    public MyCyclicBarrier2(int parties) {
        p = parties;
    }

    public void await() {
        counter = counter + 1;
    }
}
