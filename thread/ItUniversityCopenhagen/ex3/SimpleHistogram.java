package thread.ItUniversityCopenhagen.ex3;// For week 3
// sestoft@itu.dk * 2014-09-04

public class SimpleHistogram {
    public static void main(String[] args) {
        final Histogram histogram = new Histogram1(30);
        histogram.increment(7);
        histogram.increment(13);
        histogram.increment(7);
        dump(histogram);
    }

    public static void dump(Histogram histogram) {
        int totalCount = 0;
        for (int item = 0; item < histogram.getSpan(); item++) {
            System.out.printf("%4d: %9d%n", item, histogram.getCount(item));
            totalCount += histogram.getCount(item);
        }
        System.out.printf("      %9d%n", totalCount);
    }

    public static String dumpToString(Histogram histogram) {
        int totalCount = 0;
        StringBuilder stringBuffer = new StringBuilder();
        for (int item = 0; item < histogram.getSpan(); item++) {
            stringBuffer.append(String.format("%4d: %9d%n", item, histogram.getCount(item)));
            totalCount += histogram.getCount(item);
        }
        stringBuffer.append(String.format("      %9d%n", totalCount));
        return stringBuffer.toString();
    }
}

