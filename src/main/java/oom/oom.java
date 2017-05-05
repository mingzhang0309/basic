package oom;

import java.util.ArrayList;

/**
 * Created by stephen.zhang on 17/4/13.
 */
public class oom {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String >();
        int i = 0;
        while (true) {
            list.add("aaaa " + i++);
            System.out.println(i);
        }
    }
}
