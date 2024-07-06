import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int NumOfMes = Integer.parseInt(args[1]);

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        ExecutorService executorService = Executors.newFixedThreadPool(N*2);

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < NumOfMes; k++)
            {
                executorService.submit(new Writer(queue, i, k));
                executorService.submit(new Reader(queue, i, k));
            }
        }
        executorService.shutdown();
    }
}