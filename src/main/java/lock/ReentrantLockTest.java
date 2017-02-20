package lock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stephen.zhang on 16/5/10.
 */
public class ReentrantLockTest {
    private static final ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
//        Action action1 = new Action();
//        Action action2 = new Action();
//
//        Thread thread1 = new Thread(action1);
//        Thread thread2 = new Thread(action1);
//        thread1.start();
//        thread2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println(lock.getHoldCount());
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lock.lock();
//                System.out.println(lock.getHoldCount());
//            }
//        }).start();
    }
}
