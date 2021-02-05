package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Job1 implements Runnable {
    private static int n = 1;
    private final int num = n++;
    private final int priority;
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        for (int i = 0; i < 3; i++) {
            System.out.println("Job" + num + " run " + (i + 1) + " time");
            // Thread.yield();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Job" + num + "  finished");
    }

    public Job1 (int i) {
        this.priority = i;
        System.out.println("Job" + num + "  built");
    }

    public static void main(String[] args) {
        List<Future<String>> results = new ArrayList<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            results.add(executorService.submit(new Job2()));
            //executorService.execute();
        }
        results.forEach(e -> {
            try {
                System.out.println(e.get());
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        });
        executorService.shutdown();
    }

}
