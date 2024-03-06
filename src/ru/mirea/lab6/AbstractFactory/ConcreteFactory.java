package ru.mirea.lab6.AbstractFactory;

class ConcreteFactory implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB();
    }
}
