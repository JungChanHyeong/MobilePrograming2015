package kr.ac.kookmin.exception.synchronize;

public class ThreadMain extends Thread{
	static Datacount dc;
	
	public static void main(String arg[]) throws InterruptedException {
		ThreadMain tm = new ThreadMain();
		dc = new Datacount();
		
		tm.start();
		
		Thread.sleep(10);
		
		synchronized(tm) {
			while(dc.getCnt() < 10) {
				dc.addCnt();
			}
			tm.notify();
		}
	}
	
	public void run() {
		dc.addCntUntil3();
	}	
}
