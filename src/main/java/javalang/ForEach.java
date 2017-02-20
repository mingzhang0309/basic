package javalang;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stephen.zhang on 17/1/4.
 */
public class ForEach {
    public static void main(String[] args) {
        Set<String> sets = new HashSet<String>();
        sets.add("aa");
        sets.add("bb");

        for(String s : sets) {
            System.out.println(s);
        }
    }
}
