package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by stephen.zhang on 16/10/15.
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            public Worker(String name) {
                super(name);
            }

            public void run() {
                while (true) {
                    lock.lock();

                    try {
                        Thread.sleep(1000L);
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000L);
                    } catch (Exception ex) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            Worker w = new Worker(String.valueOf(i));
            w.start();
        }

        new Thread() {
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(500L);
                        System.out.println();
                    } catch (Exception ex) {

                    }
                }
            }
        }.start();

        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class TwinsLock implements Lock {
        private final Sync	sync	= new Sync(1);

        private static final class Sync extends AbstractQueuedSynchronizer {
            private static final long	serialVersionUID	= -7889272986162341211L;

            Sync(int count) {
                if (count <= 0) {
                    throw new IllegalArgumentException("count must large than zero.");
                }
                setState(count);
            }

            public int tryAcquireShared(int reduceCount) {
                for (;;) {
                    int current = getState();
                    int newCount = current - reduceCount;
                    if (newCount < 0 || compareAndSetState(current, newCount)) {
                        return newCount;
                    }
                }
            }

            public boolean tryReleaseShared(int returnCount) {
                for (;;) {
                    int current = getState();
                    int newCount = current + returnCount;
                    if (compareAndSetState(current, newCount)) {
                        return true;
                    }
                }
            }
        }

        public void lock() {
            sync.acquireShared(1);
        }

        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
        }

        public boolean tryLock() {
            return sync.tryAcquireShared(1) >= 0;
        }

        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireSharedNanos(1, unit.toNanos(time));
        }

        public void unlock() {
            sync.releaseShared(1);
        }

        @Override
        public Condition newCondition() {
            return null;
        }
    }
}
