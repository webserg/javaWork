package ThreadLocal;


public class SerialNum2 {

	/**
	 * @param args
	 */
	
	int i=0;
	
	public class PrimeThread extends Thread {
        long minPrime;
        PrimeThread(long minPrime) {
            this.minPrime = minPrime;
        }

        public void run() {
        	
        	while (true) {
        		System.out.println(Thread.currentThread().getName() + " " +   SerialNum.get());
        		if(--minPrime < 0) return;
			}
        }
    }
	
	public static void main(String[] args) {
		SerialNum2 serialNum2 = new SerialNum2();
		
		SerialNum2.PrimeThread p = serialNum2.new PrimeThread(10);
		SerialNum2.PrimeThread p2 = serialNum2.new PrimeThread(10);
		p2.start();
		p.start();
		
	}

}
