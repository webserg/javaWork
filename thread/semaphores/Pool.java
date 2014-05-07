package thread.semaphores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

/**
 * Created by IntelliJ IDEA.
 * User: serg
 * Date: Nov 17, 2008
 * Time: 11:15:32 PM
 * To change this template use File | Settings | File Templates.
 */
class Pool { // Incomplete
    protected java.util.ArrayList items = new ArrayList();

    protected java.util.HashSet busy = new HashSet();

    protected final Semaphore available;

    public Pool(int n) {
	available = new Semaphore(n);
	initializeItems(n);
    }

    public Object getItem() throws InterruptedException {
	available.acquire();
	return doGet();
    }

    public void returnItem(Object x) {
	if (doReturn(x))
	    available.release();
    }

    protected synchronized Object doGet() {
	Object x = items.remove(items.size() - 1);
	busy.add(x); // put in set to check returns
	return x;
    }

    protected synchronized boolean doReturn(Object x) {
	if (busy.remove(x)) {
	    items.add(x); // put back into available item list
	    return true;
	} else
	    return false;
    }

    protected void initializeItems(int n) {
	// Somehow create the resource objects
	//  and place them in items list.
    }
}
