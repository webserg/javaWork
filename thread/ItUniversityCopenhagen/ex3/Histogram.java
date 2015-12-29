package thread.ItUniversityCopenhagen.ex3;

/**
 * Created by webserg on 12/29/2015.
 */
public interface Histogram {
    void increment(int item);

    int getCount(int item);

    int getSpan();
}
