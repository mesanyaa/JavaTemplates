package ru.mirea.lab7.Facade;

// Пример использования фасада
public class Main {
    public static void main(String[] args) {
        // Создание объекта фасада
        Facade facade = new Facade();

        // Использование фасада для выполнения операции AB
        facade.operationAB();

        // Использование фасада для выполнения операции BC
        facade.operationBC();
    }
}
