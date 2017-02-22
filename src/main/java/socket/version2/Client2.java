package socket.version2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/2/22.
 */
public class Client2 {
    public static void main(String[] args) {
        try {
            for(int i = 0; i < 1; i++) {
                Socket socket = new Socket(InetAddress.getLocalHost(), 5566);

                OutputStream outputStream = socket.getOutputStream();
                String name = "stephen c2" + i + "\n";
                outputStream.write(name.getBytes());

                InputStream inputStream = socket.getInputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
