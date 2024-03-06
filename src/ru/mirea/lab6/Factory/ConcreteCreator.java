package ru.mirea.lab6.Factory;

class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
