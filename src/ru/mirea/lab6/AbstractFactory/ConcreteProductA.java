package ru.mirea.lab6.AbstractFactory;

class ConcreteProductA implements AbstractProductA {
    @Override
    public void operationA() {
        System.out.println("ConcreteProductA operation");
    }
}
