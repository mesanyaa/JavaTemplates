package ru.sejapoe.pr6.factory;

interface Product {
    void operation();
}

class ConcreteProduct implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct operation");
    }
}

abstract class Creator {
    abstract Product factoryMethod();

    void someOperation() {
        Product product = factoryMethod();
        product.operation();
    }
}

class ConcreteCreator extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProduct();
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        creator.someOperation();
    }
}
