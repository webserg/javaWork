package thread.scjp.threads;

public class AccountDanger implements Runnable {
	Account account = new Account();
	int k =1;
	int t = 1;
	int c;
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithdraw(10);
			if (account.getBalance() < 0)
				System.out.println("overdraw");
			System.out.println(account.getBalance());
			useFredSecret(1);
		}
		System.out.println(Thread.currentThread().getName() + " "
				+ account.getFradSecret());
	}

	private synchronized void useFredSecret(int amount) {
		System.out.println(Thread.currentThread().getName()
				+ " is doing to add secret");
		if (account.getFradSecret() < 5) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.addFradSecret(amount);
		}
	}

	private synchronized void makeWithdraw(int amount) {
		if (account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName()
					+ " is doing withdraw");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()
					+ " has copmleted the withdrawl");
		} else {
			System.out.println("money isn't enought");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AccountDanger accountDanger = new AccountDanger();
		Thread fred = new Thread(accountDanger, "Fred");
		Thread lucka = new Thread(accountDanger, "Lucka");
		fred.start();
		lucka.start();

	}

}

class Account {
	private int balance = 50;

	private int fradSecret = 0;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getFradSecret() {
		return fradSecret;
	}

	public void addFradSecret(int fradSecret) {
		this.fradSecret += fradSecret;
	}
}
