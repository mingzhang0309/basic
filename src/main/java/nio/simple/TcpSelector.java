package nio.simple;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by stephen.zhang on 17/2/22.
 */
public class TcpSelector {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), 5566));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                if(selector.select() == 0) {
                    System.out.println(".");
                }

                for (SelectionKey selectionKey : selector.keys()) {
                    if(selectionKey.isAcceptable()) {

                    }

                    if(selectionKey.isValid() && selectionKey.isWritable()) {

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
