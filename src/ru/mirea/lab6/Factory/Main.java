package ru.mirea.lab6.Factory;

public class Main {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        product.operation();
    }
}
