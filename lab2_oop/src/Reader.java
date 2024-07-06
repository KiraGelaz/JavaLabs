import java.util.concurrent.BlockingQueue;

public class Reader implements Runnable {
    private final BlockingQueue<String> queue;
    private final int id;
    private final int num;

    public Reader(BlockingQueue<String> queue, int id, int num) {
        this.queue = queue;
        this.num = num;
        this.id = id;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Reader-" + id);
        System.out.println("Thread " + Thread.currentThread().getName() + " reads a message: " + read());
    }

    public String read(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
