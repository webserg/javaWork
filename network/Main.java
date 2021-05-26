package network;

/**
 * I/O in Java is built on streams. Input streams read data; output streams write data.
 * Different stream classes, like java.io.FileInputStream and sun.net.TelnetOutput
 * Stream, read and write particular sources of data. However, all output streams have the
 * same basic methods to write data and all input streams use the same basic methods to
 * read data. After a stream is created, you can often ignore the details of exactly what it
 * is you’re reading or writing.
 *
 *
 *
 * Streams are synchronous; that is, when a program (really a thread) asks a stream to read
 * or write a piece of data, it waits for the data to be read or written before it does anything
 * else. Java also offers nonblocking I/O using channels and buffers. Nonblocking I/O is a
 * little more complicated, but can be much faster in some high-volume applications
 *
 *
 */
public class Main {
    public static void main(String[] args) {

    }
}
