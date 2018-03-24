package thread.caches.lru;

import org.junit.Before;
import org.junit.Test;
import thread.caches.KeyObject;
import thread.caches.UserOfCache;
import thread.caches.ValueObject;

/**
 * @author Sergiy Doroshenko
 * email:webserg@gmail.com
 * Date: 1/14/11 2:52 PM
 */
public class LinkedListLRUCacheTest extends AbstractLinkedListLRUCacheTest {

    @Before
    public void setUp() throws Exception {
        UserOfCache.erase();
        UserOfCache.createInstance(new LinkedListLRUCache<KeyObject, ValueObject>(10), fillStorage());
    }

    @Test
    public void testConcurrancy() {

    }


}
