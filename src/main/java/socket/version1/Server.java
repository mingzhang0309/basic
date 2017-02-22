package socket.version1;

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

                OutputStream outputStream = socket.getOutputStream();
                InputStream inputStream = socket.getInputStream();

                String out = "Hello ";
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder input = new StringBuilder(out);
                String line = reader.readLine();

                input.append(line);
                input.append("\n");
                System.out.println("write " + input.toString());

                outputStream.write(input.toString().getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
