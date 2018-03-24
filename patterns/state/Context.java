package patterns.state;

import java.nio.ByteBuffer;

/**
 * Created by sergiy.doroshenko
 * Date: 7/10/11
 */
interface Context {
    ByteBuffer buffer();

    State state();

    void state(State state);
}
