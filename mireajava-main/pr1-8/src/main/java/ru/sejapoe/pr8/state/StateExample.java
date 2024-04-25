package ru.sejapoe.pr8.state;

import lombok.Setter;

// Интерфейс для состояния
interface State {
    void handle();
}

// Конкретные состояния
class ConcreteStateA implements State {
    @Override
    public void handle() {
        System.out.println("State A handled");
    }
}

class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("State B handled");
    }
}

// Контекст
@Setter
class Context {
    private State state;

    public void request() {
        state.handle();
    }
}

// Пример использования
public class StateExample {
    public static void main(String[] args) {
        Context context = new Context();

        State stateA = new ConcreteStateA();
        State stateB = new ConcreteStateB();

        context.setState(stateA);
        context.request();

        context.setState(stateB);
        context.request();
    }
}
