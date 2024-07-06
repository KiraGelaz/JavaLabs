public class Supervisor implements Runnable {
    private Sync sync;
    private final AbstractClass program;
    private Thread programThread;

    public Supervisor(AbstractClass program, Sync sync) {
        this.program = program;
        this.sync = sync;
        this.programThread = new Thread(program);
        System.out.println("Supervisor created");
    }

    public void startAbstractProgram() {
        new Thread(program).start();
    }

    public void stopAbstractProgram() {
        programThread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("Stopped because of FATAL ERROR");
        System.exit(1);
    }

    public void restart() {
        programThread.interrupt();
        programThread = new Thread(program);
        programThread.start();
    }

    @Override
    public void run() {
        synchronized (sync){
            while(program.getStatus() != AbstractClass.status.FATAL_ERROR) {
                while(sync.sync != 1) {
                    try {
                        sync.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (program.state == AbstractClass.status.STOPPING) {
                    program.setState(AbstractClass.status.RUNNING);
                    System.out.println("Supervisor: changed status to   " + program.getStatus());
                }
                else {
                    System.out.println("Supervisor: all is okay!");
                }
                sync.sync = 0;
                sync.notifyAll();
            }
        }
    }
}
