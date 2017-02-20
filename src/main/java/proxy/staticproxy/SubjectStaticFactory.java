package proxy.staticproxy;

/**
 * Created by stephen.zhang on 16/9/28.
 */
public class SubjectStaticFactory {
    public static Subject getInstance(){
        return new ProxySubject(new RealSubject());
    }
}
