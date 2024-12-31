package br.com.goqueiroz;

import java.time.Duration;

/***
 * Here is an example of normal Thread. Only one Thread to process.
 * In this case, the duration should be close 10 seconds
 */
public class Threads {

    public static void main(String[] args) {
        long timeInit = System.currentTimeMillis();

        for (int i = 0; i < 10; i++ ){
            new Processor().execute(i).run();
        }

        long processorDuration = Duration.ofMillis(System.currentTimeMillis() - timeInit).toSeconds();
        System.out.println(processorDuration + " seconds.");
    }
}
