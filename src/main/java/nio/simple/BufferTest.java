package nio.simple;

import java.nio.CharBuffer;

/**
 * Created by stephen.zhang on 17/2/23.
 */
public class BufferTest {
    public static void main(String[] argv) throws Exception {
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
//            drainBuffer(buffer);
//            buffer.clear();
            System.out.println(buffer.get());
            System.out.println(buffer.get());
            System.out.println(buffer.get());
            buffer.compact();
            System.out.println(buffer.get());
            System.out.println(buffer.get());
            System.out.println(buffer.get());
            System.out.println(buffer.get());
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return (false);
        }
        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }

    private static int index = 0;
    private static String[] strings = { "Helio", };
}
