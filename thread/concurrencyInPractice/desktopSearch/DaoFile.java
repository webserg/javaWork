package thread.concurrencyInPractice.desktopSearch;

import java.io.File;

public class DaoFile implements Dao {

    @Override
    public boolean alreadyIndexed(File entry) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void indexFile(File f) {
        System.out.println(f.toString());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub

    }

}
