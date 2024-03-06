package ru.mirea.lab6.Factory;

class ConcreteProduct implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProduct operation");
    }
}
