package ru.sejapoe.pr3;

import java.util.*;

class SynchronizedSet<E> implements Set<E> {
    private final Set<E> set;

    public SynchronizedSet(Set<E> set) {
        this.set = set;
    }

    @Override
    public synchronized int size() {
        return set.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public synchronized Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return set.toArray();
    }

    @Override
    public synchronized <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    public synchronized boolean add(E e) {
        return set.add(e);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    public synchronized void clear() {
        set.clear();
    }
}

public class SynchronizedSetExample {
    public static void main(String[] args) throws InterruptedException {
        // Обычный set
        Set<Integer> unsynchronizedSet = new HashSet<>();

        // Синхронизированный set
        Set<Integer> synchronizedSet = new SynchronizedSet<>(new HashSet<>());

        // Создаем и запускаем потоки для добавления элементов в оба сета
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            final int numToAdd = i + 1;
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(100); // Добавляем задержку для создания условий гонки данных
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                unsynchronizedSet.add(numToAdd);
                synchronizedSet.add(numToAdd);
            });
            threads[i].start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Выводим содержимое обоих сетов
        System.out.println("Unsynchronized Set:");
        for (Integer num : unsynchronizedSet) {
            System.out.println(num);
        }

        System.out.println("Synchronized Set:");
        for (Integer num : synchronizedSet) {
            System.out.println(num);
        }
    }
}