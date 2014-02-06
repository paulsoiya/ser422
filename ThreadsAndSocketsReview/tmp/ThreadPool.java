import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ThreadPool {
    public static void main(String args[]) throws Exception {
        Executor pool = Executors.newFixedThreadPool(2);

        for (int i=0; i < 5; i++) {
            pool.execute(new Worker(i));  // Worker from previous example
        }
    }
}
