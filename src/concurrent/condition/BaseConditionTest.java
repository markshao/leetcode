package concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BaseConditionTest {

	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void test() throws Exception {
		new Thread() {
			public void run() {
				try {
					lock.lock();
					System.out.println("I get the lock");
					condition.await();
					System.out.println("I am back");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}.start();

		new Thread() {
			public void run() {
				try {
					lock.lock();
					System.out.println("U get the lock");
					condition.signalAll();
					Thread.sleep(3000);
					System.out.println("U am back");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}.start();
	}

	public static void main(String[] args) throws Exception {
		new BaseConditionTest().test();
	}
}
