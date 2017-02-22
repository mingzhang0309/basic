package socket.version2;

import java.io.*;
import java.net.Socket;

/**
 * Created by stephen.zhang on 17/2/22.
 */
public class Handler implements Runnable {
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " process");
            Thread.sleep(5000);

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
