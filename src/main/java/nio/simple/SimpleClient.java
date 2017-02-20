package nio.simple;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/1/10.
 */
public class SimpleClient {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1; i++) {
                Server server = new Server();
                server.run();
                System.out.println("第"+(i+1)+"次连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
