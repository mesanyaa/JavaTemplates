package ru.mirea.lab3;

public class ConcurrentMapTest {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentMap<>();

        // Добавление элементов в потокобезопасную карту
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Получение элементов из потокобезопасной карты
        System.out.println("Value for key 'A': " + map.get("A"));
        System.out.println("Value for key 'B': " + map.get("B"));
        System.out.println("Value for key 'C': " + map.get("C"));
    }
}
