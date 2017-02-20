package proxy.staticproxy;

/**
 * Created by stephen.zhang on 16/9/28.
 */
public class Client {
    public static void main(String[] args) {
        Subject proxy = SubjectStaticFactory.getInstance();
        proxy.dealTask("DBQueryTask");
    }
}
