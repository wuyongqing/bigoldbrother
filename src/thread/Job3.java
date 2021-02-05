package thread;

public class Job3 extends Thread {
    private int num;
    private int duration;
    public Job3 (int num, int duration) {
        this.num = num;
        this.duration = duration;
    }
    @Override
    public void run() {
        //System.out.println("Job3 " + num + " run " + (i + 1));
        System.out.println("Job3 " + num + " run ");
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted ");
                e.printStackTrace();
            }
        //}
    }

    public void joinIn(Job3 job3) {
        try {
            job3.join();
            System.out.println(job3.num + " joined " + this.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Job3 job1 = new Job3(1,1000);
        Job3 job2 = new Job3(2,3000);
        job1.start();
        job2.start();
    }
}
