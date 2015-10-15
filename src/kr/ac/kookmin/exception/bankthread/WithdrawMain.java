package kr.ac.kookmin.exception.bankthread;

public class WithdrawMain implements Runnable {
	private BankAccount account = new BankAccount();

	public static void main(String[] args) {
		WithdrawMain job = new WithdrawMain();
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);

		t1.setName("han");
		t2.setName("lim");
		t1.start();
		t2.start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			withDrawMoney(10);
			if (account.getBalance() < 0) {
				System.out.println("잔고현황 : " + account.getBalance() + " 계좌 한도를 벗어나서 인출 되어졌습니다. 치명적인 에러");
			}
		}
	}

	public synchronized void withDrawMoney(int amount) {
		if (account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName() + " 가 인출 시도 합니다");
			try {
				System.out.println(Thread.currentThread().getName() + " 인출 시작 전 0.5초 대기합니다.");
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " 인출시작.");
			account.withDraw(amount);
			System.out.println(Thread.currentThread().getName() + " 인출완료. ");
		} else {
			System.out.println(Thread.currentThread().getName() + "는 인출할 돈이 없습니다.. ");
		}
	}
}
