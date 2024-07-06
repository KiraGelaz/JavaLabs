import java.util.Random;

public class AbstractClass implements Runnable {
    public enum status {
        UNKNOWN,
        STOPPING,
        RUNNING,
        FATAL_ERROR
    }
    protected Object supervisorMutex = new Object();
    public status state;
    private Sync sync;
    public AbstractClass(status state, Sync sync) {
        this.state = state;
        this.sync = sync;
        DeamonThread deamon = new DeamonThread(this, sync);
        deamon.setDaemon(true);
        deamon.start();
    }
    public void setState(AbstractClass.status state) {
        this.state = state;
    }
    public status getStatus() {
        return state;
    }

    @Override
    public void run() {
        synchronized (sync) {
            while (getStatus() != AbstractClass.status.FATAL_ERROR) {
                while (sync.sync != 0) {
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Abstract program: my state is    " + getStatus());
                sync.sync = 2;
                sync.notifyAll();
            }
        }
    }
}
