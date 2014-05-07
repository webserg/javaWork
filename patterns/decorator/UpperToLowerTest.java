package patterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

public class UpperToLowerTest extends TestCase {
    public static void testInput() {
	StringBuilder res = new StringBuilder();
	try {
	    InputStream in = new UpperToLowerCaseInputStream(
		    new BufferedInputStream(new FileInputStream("D:/devel/workingSnap/patterns/decorator/test.txt")));
	    int c;

	    while ((c = in.read()) != -1) {
		
		res.append((char) c);
	    }
	    in.close();
	} catch (IOException e) {

	    e.printStackTrace();
	}
	assertEquals("i know the decorator pattern therefore i rule!", res
		.toString());
    }
}
