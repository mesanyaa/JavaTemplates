package ru.mirea.lab1;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Пример использования
        Integer[] numbers = {5, 2, 9, 1, 3};
        Arrays.sort(numbers);
        Consumer<Integer[]> consumer = nums -> {
            for (int num : nums) {
                System.out.print(num + " ");
            }
        };
        consumer.accept(numbers);
    }
}