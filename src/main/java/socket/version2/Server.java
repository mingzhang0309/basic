package socket.version2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/2/22.
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5566);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new Handler(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
