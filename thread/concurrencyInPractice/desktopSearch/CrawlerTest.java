package thread.concurrencyInPractice.desktopSearch;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CrawlerTest {
    public static void startIndexing(File[] roots) {
        Dao dao = new DaoFile();
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>();
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        };
        for (File root : roots)
            new Thread(new FileCrawler(queue, filter, root, dao)).start();
        for (int i = 0; i < 10; i++)
            new Thread(new Indexer(queue, dao)).start();
    }

    public static void main(String[] args) {
        startIndexing(new File[]{new File("c:/books")});
    }

}
