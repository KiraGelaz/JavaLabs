import java.util.Random;

public class DeamonThread extends Thread implements Runnable {
    private Sync sync;
    private AbstractClass prog;
    private Random num;
    public DeamonThread(AbstractClass prog, Sync sync) {
        this.sync = sync;
        this.prog = prog;
        num = new Random();
    }

    @Override
    public void run() {
       synchronized (sync) {
           while (true) {
               while (sync.sync != 2) {
                   try {
                       sync.wait();
                   }
                   catch (InterruptedException e) {
                       throw new RuntimeException();
                   }
               }
               if (num.nextInt(10) < 9) {
                   prog.setState(AbstractClass.status.values()[num.nextInt(2) + 1]);
                   System.out.println("Daemon: I set state   " + prog.getStatus());
               }
               else{
                   prog.setState(AbstractClass.status.FATAL_ERROR);
               }
               sync.sync = 1;
               sync.notifyAll();
           }
       }
    }
}
