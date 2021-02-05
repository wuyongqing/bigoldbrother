package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Job2 implements Callable {
    private static int n = 1;
    private final int num = n++;
    @Override
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Job" + num + " called ";
    }
}
