package nio.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/1/9.
 */
public class SimpleServerWithResponse {
    private static final int MAX_INPUT = 1024;
    private int count = 0;

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8097, 2);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " +
                        socket.getInetAddress() + ":" +socket.getPort());
//                new Thread(new Handler(socket)).start();
            }
        } catch (IOException e) {
        } finally {

        }
    }

    static class Handler implements Runnable {
        final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                byte[] input = new byte[MAX_INPUT];
                InputStream inputStream = socket.getInputStream();
                inputStream.read(input);
                byte[] output = process(input);
                socket.getOutputStream().write(output);
            } catch (IOException ex) { /* ... */
            } catch (InterruptedException e) {
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

        private byte[] process(byte[] input) {
            String str = new String(input);
            System.out.println(str);
            return input;
        }
    }

    public static void main(String[] args) {
        SimpleServerWithResponse simpleServer = new SimpleServerWithResponse();
        simpleServer.run();
    }
}
