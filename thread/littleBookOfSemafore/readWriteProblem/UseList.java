package thread.littleBookOfSemafore.readWriteProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webserg on 07.05.2014.
 */
public class UseList {
    public final List<Integer> list = new ArrayList<>();

    public Integer getIfExists(int idx) {
        int _idx = list.size();
        if (idx >= 0 && idx <= _idx)
            return list.get(idx);
        throw new
                IllegalArgumentException("" + idx);
    }
}
