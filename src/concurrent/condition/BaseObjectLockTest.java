package concurrent.condition;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mark on 2/10/14.
 */
public class BaseObjectLockTest {

    private Object readLock = new Object();

    public void test() {
        new Thread("Thread-1") {
            public void run() {
                synchronized (readLock) {
                    System.out.println(this.getName() + " get the lock");
                    try {
                        readLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + " is back");
                    readLock.notify();
                }
            }
        }.start();

        new Thread("Thread-2") {
            public void run() {
                synchronized (readLock) {
                    System.out.println(this.getName() + " get the lock");
                    try {
                        readLock.notify();
                        readLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + " is back");
                }
            }
        }.start();
    }

    public static void main(String[] args) throws Exception {
        new BaseObjectLockTest().test();
    }
}


