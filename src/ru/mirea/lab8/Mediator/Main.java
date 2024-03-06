package ru.mirea.lab8.Mediator;

// Пример использования паттерна "Посредник"
public class Main {
    public static void main(String[] args) {
        // Создание посредника
        ConcreteMediator mediator = new ConcreteMediator();

        // Создание коллег
        Colleague colleague1 = new ConcreteColleague(mediator);
        Colleague colleague2 = new ConcreteColleague(mediator);
        Colleague colleague3 = new ConcreteColleague(mediator);

        // Регистрация коллег в посреднике
        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);
        mediator.addColleague(colleague3);

        // Отправка сообщений
        colleague1.sendMessage("Привет, это коллега 1!");
        colleague2.sendMessage("Привет, это коллега 2!");
    }
}
