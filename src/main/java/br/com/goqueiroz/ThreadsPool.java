package br.com.goqueiroz;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * Here is an example of Thread Pool. We can define a number of threads that will be provided.
 * In this case, the duration is relative to the number of threads.
 * For example: to 10 processor with 5 threads the durations should be close to 2 seconds
 */
public class ThreadsPool {

    public static void main(String[] args) {
        long timeInit = System.currentTimeMillis();

        try(ExecutorService executorService = Executors.newFixedThreadPool(5)) {
            for (int i = 0; i < 10; i++) {
                Runnable processor = new Processor().execute(i);
                executorService.submit(processor);
            }
        }

        long processorDuration = Duration.ofMillis(System.currentTimeMillis() - timeInit).toSeconds();
        System.out.println(processorDuration + " seconds.");
    }
}
