package ru.mirea.lab2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Создаем список людей
        List<Human> humans = List.of(
                new Human("Alice", LocalDate.of(1995, 5, 15), 60),
                new Human("Bob", LocalDate.of(2002, 3, 10), 70),
                new Human("Charlie", LocalDate.of(1990, 11, 25), 65)
        );

        // Увеличиваем вес каждого объекта на 3
        humans = humans.stream()
                .peek(human -> human = new Human(human.getName(), human.getBirthDate(), human.getWeight() + 3))
                .collect(Collectors.toList());

        // Сортируем по весу в обратном порядке
        humans = humans.stream()
                .sorted((h1, h2) -> Integer.compare(h2.getWeight(), h1.getWeight()))
                .collect(Collectors.toList());

        // Фильтруем по дате рождения меньшей, чем 01.01.2000
        humans = humans.stream()
                .filter(human -> human.getBirthDate().isBefore(LocalDate.of(2000, 1, 1)))
                .collect(Collectors.toList());

        // Выводим в консоль список после всех операций
        humans.forEach(System.out::println);

        // Считаем сумму всех весов
        int totalWeight = humans.stream()
                .mapToInt(Human::getWeight)
                .sum();

        System.out.println("Сумма всех весов: " + totalWeight);
    }
}

