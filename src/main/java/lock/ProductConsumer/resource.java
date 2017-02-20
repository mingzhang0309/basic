package lock.ProductConsumer;

import java.util.LinkedList;

/**
 * Created by stephen.zhang on 16/10/29.
 */
public class resource {
    private LinkedList<String> list = new LinkedList<String>();

    public void put() throws InterruptedException {
        synchronized (list) {
            while (list.size() >= 5) {
                try {
                    System.out.println(Thread.currentThread().getName() + " 满，等待 "+ list.size());

                    list.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " ru");
                }
            }
            Thread.sleep(100);
            list.add("a");
            System.out.println(Thread.currentThread().getName() + " 放入a " + list.size());
            list.notifyAll();
        }
    }

    public void get() throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + " get满，等待 " + list.size());
                    list.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread() + " ru");
                }
            }
        Thread.sleep(100);
        list.removeLast();
        System.out.println(Thread.currentThread().getName() + " 获取a " + list.size());
        list.notifyAll();
        }
    }

    public static void main(String[] args) {
        final resource r = new resource();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            r.put();
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread() + " main ru");
                        }
                    }
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            r.get();
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread() + " main ru");
                        }
                    }
                }
            }).start();
        }
    }
}
