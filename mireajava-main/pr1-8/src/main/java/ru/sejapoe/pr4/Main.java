package ru.sejapoe.pr4;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Phaser;


class CustomExecutorService {
    private final int poolSize;
    private final List<WorkerThread> threads;
    private final BlockingQueue<Runnable> taskQueue;
    private final Phaser phaser;

    public CustomExecutorService(int poolSize) {
        this.poolSize = poolSize;
        this.threads = new ArrayList<>(poolSize);
        this.taskQueue = new LinkedBlockingQueue<>();
        this.phaser = new Phaser(1);

        for (int i = 0; i < poolSize; i++) {
            WorkerThread workerThread = new WorkerThread();
            threads.add(workerThread);
            workerThread.start();
        }
    }

    public void submit(Runnable task) {
        try {
            phaser.register();
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        phaser.arriveAndAwaitAdvance();
        for (WorkerThread thread : threads) {
            thread.stopThread();
        }
    }

    private class WorkerThread extends Thread {
        private boolean running = true;

        @Override
        public void run() {
            while (running) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                    phaser.arriveAndDeregister();
                } catch (InterruptedException e) {
                    running = false;
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopThread() {
            running = false;
            interrupt();
        }
    }

}

@Slf4j
public class Main {
    public static void main(String[] args) {
        new Main().extracted();
    }

    private void extracted() {
        CustomExecutorService executor = new CustomExecutorService(4); // создаем пул из 4 потоков
        // добавляем задачи в очередь
        for (int i = 0; i < 20; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                log.info("Task " + taskNumber + " is running in thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // имитируем выполнение задачи
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // останавливаем ExecutorService
        executor.shutdown();
    }
}
