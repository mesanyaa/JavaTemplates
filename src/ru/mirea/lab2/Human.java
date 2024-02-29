package ru.mirea.lab2;

import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate birthDate;
    private int weight;

    public Human(String name, LocalDate birthDate, int weight) {
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}

