package webserg.init;

public class InitBlock {
	
	InitBlock(int x) {
		System.out.println("1-arg const");
        c=x;
	}
	static int c=T.prt("init static filed");
	InitBlock() {
		System.out.println("no-arg const");
	}

	
	static {
		System.out.println("1st static init");
	}
	{
		System.out.println("1st instance init");
	}
	{
		System.out.println("2nd instance init");
	}
	static {
		System.out.println("2nd static init");
	}
    static final int f = 1;
    static final int g = T.prt("init final field");
	static {
		System.out.println("c=" + c);
		System.out.println("f=" + f);
	}

    static int h=T.prt("init static filed h");


	public static void main(String[] args) {
		//int k = InitBlock.c;
		//new InitBlock();
		new InitBlock(7);
        //System.out.println("k = " + InitBlock.c);
	}


}

class T {
    static int prt(String s){
        System.out.println(s);
        return 1;
    }
}