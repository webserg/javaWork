package thread.concurrencyInPractice.desktopSearch;

import java.io.File;

public interface Dao {
    void indexFile(File f);

    boolean alreadyIndexed(File entry);

}
