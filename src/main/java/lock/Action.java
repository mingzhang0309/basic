package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stephen.zhang on 16/5/10.
 */
public class Action implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    private volatile int index = 1;

    public void sleepOneSecond() {
        try {
            lock.lock();
            System.out.println("states " + lock.getHoldCount());
            lock.lock();
            Thread.sleep(2000);
            System.out.println("sleep two second " + index);
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        System.out.println(index);
        index++;
        sleepOneSecond();
    }
}
