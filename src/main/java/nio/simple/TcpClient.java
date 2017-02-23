package nio.simple;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by stephen.zhang on 17/2/22.
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            if(socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 5566))) {
                while (!socketChannel.finishConnect()) {
                    System.out.println("connect fail");
                }
            }

            String name = "stephen";
            byte[] nameBytes = name.getBytes();
            ByteBuffer writeBuf = ByteBuffer.wrap(nameBytes);
            ByteBuffer readBuf = ByteBuffer.allocate(nameBytes.length);
            int total = 0;
            int bytesRcvd;

            while (total < nameBytes.length) {
                if(writeBuf.hasRemaining()) {
                    socketChannel.write(writeBuf);
                }

                if((bytesRcvd = socketChannel.read(readBuf)) == -1) {
                    System.out.println("close");
                }

                total += bytesRcvd;
            }

            System.out.println(new String(readBuf.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
