package proxy.staticproxy;

/**
 * Created by stephen.zhang on 16/9/28.
 */
public class RealSubject implements Subject {
    @Override
    public void dealTask(String taskName) {
        System.out.println(taskName);
    }
}
