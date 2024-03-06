package ru.mirea.lab8.Mediator;
import java.util.ArrayList;
import java.util.List;

// Конкретный класс посредника
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            // Посредник отправляет сообщение всем коллегам, кроме отправителя
            if (colleague != originator) {
                colleague.receiveMessage(message);
            }
        }
    }
}
