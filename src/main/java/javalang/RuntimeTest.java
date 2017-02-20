package javalang;

import java.io.IOException;

/**
 * Created by stephen.zhang on 17/1/4.
 */
public class RuntimeTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime instanceof Object);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("shutdown");
            }
        }));

        try {
            runtime.exec("touch aa.txt");
        } catch (IOException e) {
        }
        System.out.println("start");


    }
}
