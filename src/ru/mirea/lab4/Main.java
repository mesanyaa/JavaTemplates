package ru.mirea.lab4;

public class Main {
    public static void main(String[] args) {
        // Создаем пул потоков с двумя потоками
        MyExecutorService executorService = new MyExecutorService(2);

        // Добавляем задачи в пул потоков
        for (int i = 0; i < 5; i++) {
            int taskNumber = i + 1;
            Runnable task = () -> {
                System.out.println("Task " + taskNumber + " is running in thread: " + Thread.currentThread().getName());
            };
            try {
                executorService.submit(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Завершаем работу пула потоков
        executorService.shutdown();
    }
}
