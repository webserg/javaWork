package thread.concurrencyInPractice.desktopSearch;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable {
    private final Dao dao;
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue, Dao dao) {
        this.queue = queue;
        this.dao = dao;
    }

    public void run() {
        try {
            while (true)
                dao.indexFile(queue.take());
        } catch (InterruptedException e) {

        }
        Thread.currentThread().interrupt();
    }
}
