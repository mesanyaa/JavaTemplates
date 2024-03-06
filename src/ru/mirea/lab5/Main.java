package ru.mirea.lab5;

public class Main {
    public static void main(String[] args) {
        // Тестирование SingletonLazy
        System.out.println("Testing SingletonLazy:");
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();

        System.out.println("singletonLazy1 == singletonLazy2: " + (singletonLazy1 == singletonLazy2));
        System.out.println();

        // Тестирование SingletonHolder
        System.out.println("Testing SingletonHolder:");
        SingletonHolder singletonHolder1 = SingletonHolder.getInstance();
        SingletonHolder singletonHolder2 = SingletonHolder.getInstance();

        System.out.println("singletonHolder1 == singletonHolder2: " + (singletonHolder1 == singletonHolder2));
        System.out.println();

        // Тестирование SingletonEager
        System.out.println("Testing SingletonEager:");
        SingletonEager singletonEager1 = SingletonEager.getInstance();
        SingletonEager singletonEager2 = SingletonEager.getInstance();

        System.out.println("singletonEager1 == singletonEager2: " + (singletonEager1 == singletonEager2));
    }
}
