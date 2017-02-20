package lock;

/**
 * Created by stephen.zhang on 16/10/10.
 */
public class DeadLock {
    private long value;

    public DeadLock(long value) {
        this.value = value;
    }

    public synchronized long getValue() {
        return value;
    }

    public synchronized void setValue(long value) {
        this.value = value;
    }

    public synchronized void swap(DeadLock other) {
        long t = getValue();
        long v = other.getValue();
        setValue(v);
        other.setValue(t);
    }

    public static void main(String args[]) throws Exception {
        //
        final DeadLock c1 = new DeadLock(100);
        final DeadLock c2 = new DeadLock(200);

        //
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                long count = 0;
                try {
                    while (true) {
                        c1.swap(c2);
                        count++;
                        System.out.println("thread1's current progress: " + count);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("thread1");

        //
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                long count = 0;
                try {
                    while (true) {
                        c2.swap(c1);
                        count++;
                        System.out.println("thread2's current progress: " + count);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t2.setName("thread2");

        //
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
