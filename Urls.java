import java.util.HashMap;
import java.util.Map;

public class Urls {

    private Map<String, String> longToShort = new HashMap<>();
    private Map<String, String> shortToLong = new HashMap<>();

    public String longToShort(String url) {

        return longToShort.computeIfAbsent(url, this::longToShortNew);
    }

    public String longToShortNew(String url) {
        String shortUrl;
        do {
            shortUrl = makeSortUrl(url);
        } while (!shortToLong.containsKey(shortUrl));
        longToShort.put(shortUrl, url);
        shortToLong.put(url, shortUrl);
        return shortUrl;
    }

    public String shortToLong(String url) {
        return shortToLong.getOrDefault(url, "");
    }

    private String makeSortUrl(String url) {
        return url;
    }

}
