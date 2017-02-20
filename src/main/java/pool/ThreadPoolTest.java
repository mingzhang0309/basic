package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by stephen.zhang on 16/11/8.
 */
public class ThreadPoolTest {
    static ExecutorService executorService = Executors.newCachedThreadPool();

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private static int workerCountOf(int c)  { return c & CAPACITY; }


    public static void main(String[] args) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                final int COUNT_BITS = Integer.SIZE - 3;
                System.out.println(Integer.toBinaryString(1 << COUNT_BITS - 1));
                System.out.printf("thread 1");
            }
        });
    }
}
