package lock;

import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stephen.zhang on 16/5/11.
 */
public class JobTest2 {
    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    public void fair() {
        System.out.println("fair version");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job("fair",fairLock)) {
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        // sleep 5000ms
    }

    public void unfair() {
        System.out.println("unfair version");
        for (int i = 0; i < 15; i++) {
            Thread thread = new Thread(new Job("unfair", unfairLock)) {
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        // sleep 5000ms
    }

    private static class Job implements Runnable {
        private Lock lock;
        private String name;

        public Job(String name, Lock lock) {
            this.name = name;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by:" + name + " "
                            + Thread.currentThread().getName() + " and "
                            + ((ReentrantLock2) lock).getQueuedThreads()
                            + " waits.");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        // Constructor Override
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        private static final long serialVersionUID = 1773716895097002072L;

        public Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }

    public static void main(String[] args) {
        JobTest2 jobTest2 = new JobTest2();
//        jobTest2.fair();
        jobTest2.unfair();
    }
}
