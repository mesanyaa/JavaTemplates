package ru.sejapoe.pr6.prototype;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
abstract class Prototype implements Cloneable {
    private final String id;

    public Prototype(String id) {
        this.id = id;
    }

    @Override
    @SneakyThrows
    public Prototype clone() {
        return (Prototype) super.clone();
    }
}

class ConcretePrototype1 extends Prototype {
    public ConcretePrototype1(String id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return super.clone();
    }
}

class ConcretePrototype2 extends Prototype {
    public ConcretePrototype2(String id) {
        super(id);
    }

    @Override
    public Prototype clone() {
        return super.clone();
    }
}

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Создание конкретных прототипов
        Prototype prototype1 = new ConcretePrototype1("1");
        Prototype prototype2 = new ConcretePrototype2("2");

        // Создание копий
        Prototype clone1 = prototype1.clone();
        Prototype clone2 = prototype2.clone();

        // Вывод информации
        System.out.println("Original: " + prototype1.getId());
        System.out.println("Clone: " + clone1.getId());

        System.out.println("Original: " + prototype2.getId());
        System.out.println("Clone: " + clone2.getId());
    }
}
