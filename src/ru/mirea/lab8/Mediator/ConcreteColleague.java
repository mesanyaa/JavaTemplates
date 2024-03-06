package ru.mirea.lab8.Mediator;

// Конкретный класс коллеги
class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Отправлено сообщение: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Получено сообщение: " + message);
    }
}
