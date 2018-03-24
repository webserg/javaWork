package patterns.state;

/**
 * Created by sergiy.doroshenko
 * Date: 7/10/11
 */
interface State {
    /**
     * @return true to keep processing, false to read more data.
     */
    boolean process(Context context);
}
