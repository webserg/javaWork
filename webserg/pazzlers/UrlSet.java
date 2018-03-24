package webserg.pazzlers;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class UrlSet {
    private static final String[] URL_NAMES = {
            "http://javapuzzlers.com",
            "http://apache2-snort.skybar.dreamhost.com",
            "http://www.google.com",
            "http://javapuzzlers.com",
            "http://findbugs.sourceforge.net",
            "http://www.cs.umd.edu"
    };

    public static void main(String[] args) throws MalformedURLException {
        Set<URL> fav = new HashSet<URL>();
        for (String s : URL_NAMES) {
            fav.add(new URL(s));//URL has broken equals method
        }
        System.out.println(fav.size());
        //fix use URI instead of URL
        // equals should not depend on environment
        Set<URI> fav2 = new HashSet<URI>();
        for (String s : URL_NAMES) {
            fav2.add(URI.create(s));
        }
        System.out.println(fav2.size());
    }
}
