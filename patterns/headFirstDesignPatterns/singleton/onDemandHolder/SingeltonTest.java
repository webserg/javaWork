package patterns.headFirstDesignPatterns.singleton.onDemandHolder;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by webserg on 16.05.2014.
 */
public class SingeltonTest {
    @Test
    public void testSingl() {
        Assert.assertEquals("ELVIS", Singelton.getInstance().getName());
        Singelton singelton = Singelton.getInstance();
        Assert.assertEquals(singelton, Singelton.getInstance());
        Assert.assertEquals(Singelton.getInstance(), Singelton.getInstance());
    }
}
