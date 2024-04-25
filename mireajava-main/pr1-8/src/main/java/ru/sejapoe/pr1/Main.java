package ru.sejapoe.pr1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static List<Grades> generateRandomGrades(int n) {
        var random = new Random();
        Grades[] grades = Grades.values();
        return random.ints(n, 0, grades.length).mapToObj(i -> grades[i]).toList();
    }

    public static void main(String[] args) {
        Comparator<Student> comparator = Comparator.comparingDouble(value ->
                value.grades().stream()
                        .mapToInt(Grades::getNumberRepresentation)
                        .average()
                        .orElse(0)
        );

        List<Student> students = Stream.of("Alex", "Julia", "Michael", "Grace", "Bob", "Victor")
                .map(s -> new Student(s, generateRandomGrades(10)))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(students);

        students.sort(comparator);

        System.out.println(students);

        // debug information
        System.out.println(students.stream()
                .map(student -> student.name() + ": " + student.grades()
                        .stream()
                        .mapToInt(Grades::getNumberRepresentation)
                        .average()
                        .orElse(0)).toList()
        );
    }
}