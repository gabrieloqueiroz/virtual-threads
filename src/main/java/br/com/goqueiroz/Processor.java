package br.com.goqueiroz;

import java.time.Duration;

/***
 * All methods are Runnable. Threads, PoolThreads and VirtualThreads
 */
public class Processor {
    public Runnable execute(int processorId) {
        return () -> {
            System.out.println(Thread.currentThread() + " executing processor: " + processorId);

            try {
                Thread.sleep(Duration.ofSeconds(1).toMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread() + " done process: " + processorId);
        };
    }
}
