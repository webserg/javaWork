package webserg.pazzlers;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public class Gap {
    private static final int GAP_SIZE = 10 * 1024;
    public static void main(String[] args) throws IOException {
	File tmp = File.createTempFile("gap", ".txt");
	FileOutputStream out = new FileOutputStream(tmp);
	out.write(1);
	out.write(new byte[GAP_SIZE]);
	out.write(2);
	out.close();
	InputStream in  = new BufferedInputStream(new FileInputStream(tmp));
	int first = in.read();
	//System.out.println(in.skip(GAP_SIZE));// skip bytes from 0 to your size depends on many reason
	fullySkipped(in,GAP_SIZE);
	int last = in.read();
	System.out.println(first + last);
	
    }
    
    static void fullySkipped( InputStream in, long nBytes) throws IOException{
	long remaining  = nBytes;
	while(remaining!=0){
	    long skipped = in.skip(remaining);
	    if(skipped == 0) throw new EOFException();
	    remaining -= skipped;
	}
	
    }
}
