package webserg.pazzlers;

public class Histogram {
    private static final String[]  words = 
    {"I","recommend","polygene","lubricants"};
    //"polygenelubricants".hashCode() returns Integer.MIN_VALUE
    public static void main(String[] args) {
	int[] histogram = new int[5];
	for (String w1: words) {
	    for(String w2: words) {
		String pair = w1 + w2;
		
		//Math.abs may return negotive when param = Integer.MIN_VALUE
		int bucket = Math.abs(pair.hashCode()) % histogram.length;
		histogram[bucket]++;
	    }
	}
    }
}
