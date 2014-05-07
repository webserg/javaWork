package java8.chapter1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import static junit.framework.Assert.assertEquals;

/**
 * Created by webserg on 11.04.2014.
 */
public class Task {
    public static void main(String[] args) {
        assertEquals(findLongTracks(SampleData.albumsList),findLongTracksNew(SampleData.albumsList));
    }

   // Example 3-19. Legacy code finding names of tracks over a minute in length
    public static Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for(Album album : albums) {
            for (Track track : album.getTrackList()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }

    public static Set<String> findLongTracksNew(List<Album> albums) {
        return albums.stream()
                .flatMap(album -> album.getTrackList().stream())
                .filter(track -> track.getLength() > 60)
                .map(track -> track.getName())
                .collect(Collectors.toSet());

    }
}
