package thread.ItUniversityCopenhagen.ex3;

/**
 * Created by webserg on 1/15/2016.
 */
public class Histogram1 implements Histogram {
    private int[] counts;

    public Histogram1(int span) {
        this.counts = new int[span];
    }

    public void increment(int item) {
        counts[item] = counts[item] + 1;
    }

    public int getCount(int item) {
        return counts[item];
    }

    public int getSpan() {
        return counts.length;
    }

    @Override
    public int[] getBuckets() {
        return counts;
    }
}
