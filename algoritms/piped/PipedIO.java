package algoritms.piped;


public class PipedIO {
	public static void main(String[] argv)throws Exception{
		Sender sender = new Sender();
		Reader reader = new Reader(sender);
		sender.start();
		reader.start();
		
	}
}
