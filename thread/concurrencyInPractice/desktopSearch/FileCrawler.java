package thread.concurrencyInPractice.desktopSearch;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable{
    private final Dao dao;
    private final FileFilter fileFilter;
    private final File root;
    BlockingQueue<File> fileQueue;
    
    public FileCrawler(BlockingQueue<File> queue,FileFilter fileFilter, File root,Dao dao) {
        super();
        this.fileFilter = fileFilter;
        this.root = root;
        this.fileQueue = queue;
        this.dao = dao;
    }

   

    public void run() {
        try {
            crawl(root);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException {
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry : entries)
                if (entry.isDirectory())
                    crawl(entry);
                else if (!dao.alreadyIndexed(entry)){
                    fileQueue.put(entry);
                    System.out.println("queue size = " + fileQueue.size());
                }
        }
    }

}
