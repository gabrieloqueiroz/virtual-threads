package br.com.goqueiroz;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * Here is an example of Virtual Thread. The JVM will be creating virtual threads and manager.
 * For example: to 10.000 processor should be close to 1 second.
 * Of course, the JVM will work with limitations on the resources of the machine it runs on.
 */
public class VirtualThreads {

    public static void main(String[] args) {
        long timeInit = System.currentTimeMillis();

        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10000; i++) {
                Runnable processor = new Processor().execute(i);
                executorService.submit(processor);
            }
        }

        long processorDuration = Duration.ofMillis(System.currentTimeMillis() - timeInit).toSeconds();
        System.out.println(processorDuration + " seconds.");
    }
}
