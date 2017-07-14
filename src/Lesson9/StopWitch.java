package Lesson9;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by arina on 10.07.17.
 */
public class StopWitch {
    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant stop = Instant.now();
        Duration elapsed = Duration.between(start, stop);

        System.out.println(elapsed.getSeconds());
        System.out.println(elapsed.toMillis());

        long start1 = System.nanoTime();
        long finish = System.nanoTime();
        System.out.println(finish - start1);

        //JMH

    }
}
