package ru.mirea.lab3;

public class ConcurrentSetTest {
    public static void main(String[] args) {
        ConcurrentSet<Integer> set = new ConcurrentSet<>();

        try {
            // Добавление элементов в потокобезопасное множество
            set.add(1);
            set.add(2);
            set.add(3);

            // Проверка наличия элементов в потокобезопасном множестве
            System.out.println("Contains 1: " + set.contains(1));
            System.out.println("Contains 2: " + set.contains(2));
            System.out.println("Contains 3: " + set.contains(3));
            System.out.println("Contains 4: " + set.contains(4));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

