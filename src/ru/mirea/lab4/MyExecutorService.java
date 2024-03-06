package ru.mirea.lab4;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutorService {
    private final int numThreads;
    private final PoolWorker[] threads;
    private final BlockingQueue<Runnable> queue;

    public MyExecutorService(int numThreads) {
        this.numThreads = numThreads;
        queue = new LinkedBlockingQueue<>();
        threads = new PoolWorker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        queue.put(task);
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task;
            while (true) {
                try {
                    task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public void shutdown() {
        for (PoolWorker worker : threads) {
            worker.interrupt();
        }
    }
}
