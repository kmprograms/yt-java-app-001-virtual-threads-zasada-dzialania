package kmprograms;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class AppTask implements Callable<String> {

    private final String message;

    public AppTask(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("Start: %s%n", Thread.currentThread().threadId());
        System.out.println(Thread.currentThread().isVirtual());
        TimeUnit.SECONDS.sleep(3);
        System.out.printf("Stop:  %s%n", Thread.currentThread().threadId());
        return message;
    }
}
