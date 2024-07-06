import java.util.concurrent.BlockingQueue;

public class Writer implements Runnable{
    private final BlockingQueue<String> queue;
    private final int id;
    private final int num;

    public Writer(BlockingQueue<String> queue, int id, int num) {
        this.queue = queue;
        this.num = num;
        this.id = id;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Writer-" + id);
        System.out.println("Thread " + Thread.currentThread().getName() + " is writing a message: message-" + num);
        write();
    }

    public void write(){
        try {
            queue.put("message-" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
