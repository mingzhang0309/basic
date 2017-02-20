package nio.simple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/2/14.
 */
public class Server implements Runnable {
    private static final int PORT = 8097;
    private static final int MAX_INPUT = 1024;

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(PORT);
            while (!Thread.interrupted()) {
                new Thread(new Handler(ss.accept())).start(); //创建新线程来handle
            }
            // or, single-threaded, or a thread pool
        } catch (IOException ex) { /* ... */ }
    }

    static class Handler implements Runnable {
        final Socket socket;
        Handler(Socket s) { socket = s; }
        public void run() {
            try {
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */ }
        }
        private byte[] process(byte[] cmd) {
            return "aa".getBytes();
        }
    }
}