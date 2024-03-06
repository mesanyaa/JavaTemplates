package ru.mirea.lab8.Visitor;

// Пример использования паттерна "Посетитель"
public class Main {
    public static void main(String[] args) {
        // Создание объектов элементов
        ConcreteElementA elementA = new ConcreteElementA();
        ConcreteElementB elementB = new ConcreteElementB();

        // Создание объекта посетителя
        Visitor visitor = new ConcreteVisitor();

        // Посещение элементов посетителем
        elementA.accept(visitor);
        elementB.accept(visitor);
    }
}
