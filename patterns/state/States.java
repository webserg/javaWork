package patterns.state;

/**
 * Using an enum as a state machine
 * What you can do with all these techniques is to create a enum based statement.
 * <p/>
 * In this short example, a parser state machine processes raw
 * XML from a ByteBuffer. Each state has its own process method and
 * if there is not enough data available, the state machine can return
 * to retrieve more data. Each transition between states is well defined
 * and the code for all states is together in one enum
 * <p>
 * <p>
 * Created by sergiy.doroshenko
 * Date: 7/10/11
 */


enum States implements State {
    XML {
        public boolean process(patterns.state.Context context) {
            if (context.buffer().remaining() < 16) return false;
            // read header  \
            boolean headerComplete = true;
            if (headerComplete)
                context.state(States.ROOT);
            return true;
        }
    }, ROOT {
        public boolean process(Context context) {
            if (context.buffer().remaining() < 8) return false;
            // read root tag
            boolean rootComplete = true;
            if (rootComplete) {
                //context.state(States.IN_ROOT);
            }
            return true;
        }
    };

    public boolean process(Context context) {
        //socket.read(context.buffer());
        while (context.state().process(context)) ;
        return true;
    }
}