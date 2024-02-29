package ru.mirea.lab3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class ConcurrentSet<E> {
    private final Set<E> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1);

    public void add(E element) throws InterruptedException {
        semaphore.acquire();
        try {
            set.add(element);
        } finally {
            semaphore.release();
        }
    }

    public boolean contains(E element) throws InterruptedException {
        semaphore.acquire();
        try {
            return set.contains(element);
        } finally {
            semaphore.release();
        }
    }
}


