package thread.caches.lru2;

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
 * @author Sergiy Doroshenko
 *         email:webserg@gmail.com
 *         Date: 1/14/11 2:52 PM
 */
public class CacheTest {
    List<ValueObject> storage = new ArrayList<ValueObject>();

    @Test
    public void simpleTest() {
        fill();
        UserOfCache.createInstance(new LeastRecentlyUsed2<KeyObject, ValueObject>(), storage);
        int a = 0, b = 0, c = 0, d = 0;
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0) {
                    UserOfCache.get(new KeyObject(3 + ""));
                    a++;
                } else if (i % 5 == 0) {
                    UserOfCache.get(new KeyObject(5 + ""));
                    b++;
                } else if (i % 8 == 0) {
                    UserOfCache.get(new KeyObject(8 + ""));
                    c++;
                } else {
                    UserOfCache.get(new KeyObject(i + ""));
                    d++;
                }
            }

        System.out.println("a " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        List<KeyObject> keys = UserOfCache.getAllCache();
        KeyObject[] f = {new KeyObject("3"), new KeyObject("5"), new KeyObject("8")};
        assertEquals(3, keys.size());
//        assertEquals( 3 + "", keys.get(9).getKey());
//        assertEquals( 5 + "", keys.get(8).getKey());
//        assertEquals( 8 + "", keys.get(7).getKey());
        System.out.println(keys);
        assertTrue(keys.containsAll(Arrays.asList(f)));
        UserOfCache.erase();
    }


    @Test
    public void secondTest() {
        fill();
        UserOfCache.createInstance(new LeastRecentlyUsed2<KeyObject, ValueObject>(), storage);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                UserOfCache.get(new KeyObject(3 + ""));
                a++;
            } else if (i % 5 == 0) {
                UserOfCache.get(new KeyObject(5 + ""));
                b++;
            } else if (i % 8 == 0) {
                UserOfCache.get(new KeyObject(8 + ""));
                c++;
            } else {
                UserOfCache.get(new KeyObject(i + ""));
                d++;
            }

        }
        for (int j = 0; j < 2; j++)
        for (int i = 0; i < 20; i++) {
            if (i % 3 == 0) {
                UserOfCache.get(new KeyObject(3 + ""));
                a++;
            } else if (i % 5 == 0) {
                UserOfCache.get(new KeyObject(5 + ""));
                b++;
            } else if (i % 8 == 0) {
                UserOfCache.get(new KeyObject(8 + ""));
                c++;
            } else {
                UserOfCache.get(new KeyObject(i + ""));
                d++;
            }
        }

        System.out.println("a " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        List<KeyObject> keys = UserOfCache.getAllCache();
        KeyObject[] f = {new KeyObject("3"), new KeyObject("5"), new KeyObject("8")};
        assertEquals(10, keys.size());
//        assertEquals( 3 + "", keys.get(9).getKey());
//        assertEquals( 5 + "", keys.get(8).getKey());
//        assertEquals( 8 + "", keys.get(7).getKey());
        System.out.println(keys);
        assertTrue(keys.containsAll(Arrays.asList(f)));
        UserOfCache.erase();
    }


    private void fill() {
        List<KeyObject> consumer = new ArrayList<KeyObject>();
        storage = new ArrayList<ValueObject>();
        Random random = new Random();
        random.nextInt(100);
        for (int i = 0; i < 100; i++) {
            KeyObject keyObject = new KeyObject(i + "");

            ValueObject valueObject = new ValueObject(keyObject, i + " data ");
            storage.add(valueObject);
        }

    }
}
