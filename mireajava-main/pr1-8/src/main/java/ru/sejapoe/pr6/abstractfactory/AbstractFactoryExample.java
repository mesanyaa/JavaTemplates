package ru.sejapoe.pr6.abstractfactory;
interface AbstractProductA {
    void operationA();
}

interface AbstractProductB {
    void operationB();
}

class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("ConcreteProductA1 operation");
    }
}

class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void operationB() {
        System.out.println("ConcreteProductB1 operation");
    }
}

interface AbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        productA.operationA();
        productB.operationB();
    }
}

