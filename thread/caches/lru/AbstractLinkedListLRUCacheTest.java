package thread.caches.lru;

import org.junit.Test;
import thread.caches.KeyObject;
import thread.caches.UserOfCache;
import thread.caches.ValueObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: webserg
 * Date: 16.12.12
 */
public class AbstractLinkedListLRUCacheTest {
    @Test
    public void simpleTest() {
        int usingOf3 = 0, usingOf5 = 0, usingOf8 = 0, usingOfOthers = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                UserOfCache.get(new KeyObject(3 + ""));
                usingOf3++;
            } else if (i % 5 == 0) {
                UserOfCache.get(new KeyObject(5 + ""));
                usingOf5++;
            } else if (i % 8 == 0) {
                UserOfCache.get(new KeyObject(8 + ""));
                usingOf8++;
            } else {
                UserOfCache.get(new KeyObject(i + ""));
                usingOfOthers++;
            }
        }

        System.out.println("usingOf3 " + usingOf3);
        System.out.println("usingOf5 = " + usingOf5);
        System.out.println("usingOf8 = " + usingOf8);
        System.out.println("others = " + usingOfOthers);

        List<KeyObject> keys = UserOfCache.getAllCache();
        KeyObject[] f = {new KeyObject("3"), new KeyObject("5"), new KeyObject("8")};
        assertEquals(10, keys.size());
        System.out.println(keys);
        assertTrue(keys.containsAll(Arrays.asList(f)));
    }

    protected List<ValueObject> fillStorage() {
        List<ValueObject> storage = new ArrayList<>();
        Random random = new Random();
        random.nextInt(100);
        for (int i = 0; i < 100; i++) {
            KeyObject keyObject = new KeyObject(i + "");

            ValueObject valueObject = new ValueObject(keyObject, i + " data ");
            storage.add(valueObject);
        }
        return storage;
    }
}
