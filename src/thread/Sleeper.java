package thread;

public class Sleeper extends Thread {
    private int duration;
    public Sleeper (String name, int sleepTime) {
        super(name);
        duration = sleepTime;
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted ");
            return;
        }
        System.out.println(getName() + " has awakened");
    }


}
