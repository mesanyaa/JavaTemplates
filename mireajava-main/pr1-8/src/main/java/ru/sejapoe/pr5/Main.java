package ru.sejapoe.pr5;

import lombok.SneakyThrows;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started:");
        System.out.println(Instant.now());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("First access");
        System.out.println(SingletonThroughEnum.getInstance().getCreatedAt());
        System.out.println(StaticBlockSingleton.getInstance().getCreatedAt());
        System.out.println(ThreadSafeSingleton.getInstance().getCreatedAt());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Second access:");
        System.out.println(SingletonThroughEnum.getInstance().getCreatedAt());
        System.out.println(StaticBlockSingleton.getInstance().getCreatedAt());
        System.out.println(ThreadSafeSingleton.getInstance().getCreatedAt());
    }
}
