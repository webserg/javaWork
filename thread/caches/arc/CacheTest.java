package thread.caches.arc;

import org.junit.Test;
import thread.caches.KeyObject;
import thread.caches.UserOfCache;
import thread.caches.ValueObject;
import thread.caches.lfu.CountKey;
import thread.caches.lfu.LeastFrequentlyUsed;

import java.util.*;

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
        UserOfCache.createInstance(new AdaptiveReplacementUsed<KeyObject, ValueObject>(), storage);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                UserOfCache.get(new KeyObject(3 + ""));
                a++;
            }else if (i % 5 == 0) {
                UserOfCache.get(new KeyObject(5 + ""));
                b++;
            }else if (i % 8 == 0) {
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
        assertEquals( 3 + "", keys.get(9).getKey());
        assertEquals( 5 + "", keys.get(8).getKey());
        assertEquals( 8 + "", keys.get(7).getKey());
        System.out.println(keys);
        assertTrue(keys.containsAll(Arrays.asList(f)));
        Queue<CountKey<KeyObject>> queue = new PriorityQueue<CountKey<KeyObject>>(10);
        for (KeyObject k : keys) {
            CountKey<KeyObject> countKey = new CountKey<KeyObject>(k);
            if (k.getKey().equals("5")) countKey.incrementCount();
            queue.offer(countKey);
        }
        System.out.println("------------------------------------");
        System.out.println(queue);
        CountKey countKey5 = new CountKey<KeyObject>(new KeyObject("5"));
        countKey5.incrementCount();
        CountKey countKey87 = new CountKey<KeyObject>(new KeyObject("86"));
        assertEquals(1, countKey5.compareTo(countKey87));
    }

    @Test
    public void simpleTest2() {
        UserOfCache.erase();
        fill();
        UserOfCache.createInstance(new AdaptiveReplacementUsed<KeyObject, ValueObject>(), storage);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                UserOfCache.get(new KeyObject(3 + ""));
                a++;
            }else if (i % 5 == 0) {
                UserOfCache.get(new KeyObject(5 + ""));
                b++;
            }else if (i % 8 == 0) {
                UserOfCache.get(new KeyObject(8 + ""));
                c++;
            } else {
                UserOfCache.get(new KeyObject(i + ""));
                d++;
            }
        }
        Random random = new Random();
        random.nextInt(100);
        for (int i = 0; i < 500; i++){
            int k = random.nextInt(99);
            //System.out.println("i= " + i + "; k = " + k);
             UserOfCache.get(new KeyObject(k + ""));

        }
        System.out.println("a " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        List<KeyObject> keys = UserOfCache.getAllCache();
        KeyObject[] f = {new KeyObject("3"), new KeyObject("5"), new KeyObject("8")};
        assertEquals(10, keys.size());
        assertEquals( 3 + "", keys.get(9).getKey());
        assertEquals( 5 + "", keys.get(8).getKey());
        assertEquals( 8 + "", keys.get(7).getKey());
        System.out.println(keys);
        assertTrue(keys.containsAll(Arrays.asList(f)));
        Queue<CountKey<KeyObject>> queue = new PriorityQueue<CountKey<KeyObject>>(10);
        for (KeyObject k : keys) {
            CountKey<KeyObject> countKey = new CountKey<KeyObject>(k);
            if (k.getKey().equals("5")) countKey.incrementCount();
            queue.offer(countKey);
        }
        System.out.println("------------------------------------");
        System.out.println(queue);
        CountKey countKey5 = new CountKey<KeyObject>(new KeyObject("5"));
        countKey5.incrementCount();
        CountKey countKey87 = new CountKey<KeyObject>(new KeyObject("86"));
        assertEquals(1, countKey5.compareTo(countKey87));
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
