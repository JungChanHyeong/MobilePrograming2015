package kr.ac.kookmin.exception.basicthread;

public class testMain {

	public static BankAccount account = new BankAccount();

	public static void main(String[] args) {
		Thread depositMan = new Thread() {

			public void run() {
				while (true) {
					try {
						sleep(500);
						account.add(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread withdrawMan = new Thread() {

			public void run() {
				while (true) {
					try {
						sleep(500);
						account.delete(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		};

		depositMan.start();
		withdrawMan.start();
	}
}
