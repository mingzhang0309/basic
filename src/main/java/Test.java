import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by stephen.zhang on 16/11/1.
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("2011", "1000");
        map.put("2012", "2000");
        map.put("2013", "3000");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("xxx")) {
                map.remove(entry.getKey());
            } else {
                // do nothing
            }
        }

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().startsWith("xxx")) {
                iterator.remove();
            }
        }


        System.out.println(map);
    }
}
