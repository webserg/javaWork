package collections.wildCards;

import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

/**
 * Author: Sergiy Doroshenko
 * Date: Sep 15, 2010
 * Time: 5:53:37 PM
 */
public class MultipleBounds {
    public static <S extends Readable & Closeable, T extends Appendable & Closeable> void copy(S src, T trg, int size) throws IOException {
        CharBuffer buf = CharBuffer.allocate(size);
        int i = src.read(buf);
        while (i >= 0) {
            buf.flip();
            trg.append(buf);
            buf.clear();
            i = src.read(buf);
        }
        src.close();
        trg.close();
    }
}
