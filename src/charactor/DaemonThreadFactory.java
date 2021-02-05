package charactor;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread daemon = new Thread(r);
        daemon.setDaemon(true);
        System.out.println(daemon.isDaemon());
        return daemon;
    }
}
