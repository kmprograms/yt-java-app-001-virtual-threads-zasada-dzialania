package kmprograms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class App {
    static void runTasks() {
        try (ExecutorService es = Executors.newVirtualThreadPerTaskExecutor()) {
            var tasks = IntStream
                    .range(0, 20)
                    .mapToObj(value -> new AppTask("Task no. " + value))
                    .toList();
            for (var result : es.invokeAll(tasks)) {
                System.out.println(result.resultNow());
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        runTasks();
    }
}
