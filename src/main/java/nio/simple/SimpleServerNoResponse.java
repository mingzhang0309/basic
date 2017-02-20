package nio.simple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/1/9.
 */
public class SimpleServerNoResponse {
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8097);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {
        SimpleServerNoResponse simpleServer = new SimpleServerNoResponse();
        simpleServer.run();
    }
}
