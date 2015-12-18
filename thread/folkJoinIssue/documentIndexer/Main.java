package thread.folkJoinIssue.documentIndexer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by webserg on 28.05.2014.
 * singel thread version
 */
public class Main {
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    Long countOccurrencesInParallel(Folder folder, String searchedWord) {
        return forkJoinPool.invoke(new FolderSearchTask(folder, searchedWord));
    }

    public static void main(String[] args) throws IOException {
        Folder folder = Folder.fromDirectory(new File(args[0]));
        Main main = new Main();
        System.out.println(main.countOccurrencesInParallel(folder, "the"));
//        WordCounter wordCounter = new WordCounter();
//        System.out.println(wordCounter.countOccurrencesOnSingleThread(folder, args[1]));
    }
}
