package proxy.staticproxy;

/**
 * Created by stephen.zhang on 16/9/28.
 */
public class ProxySubject implements Subject {
    private Subject delegate;

    public ProxySubject(Subject delegate) {
        this.delegate = delegate;
    }

    @Override
    public void dealTask(String taskName) {
        long stime = System.currentTimeMillis();
        //将请求分派给委托类处理
        delegate.dealTask(taskName);
        long ftime = System.currentTimeMillis();
        System.out.println("执行任务耗时"+(ftime - stime)+"毫秒");
    }
}
