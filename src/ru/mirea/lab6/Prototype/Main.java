package ru.mirea.lab6.Prototype;

public class Main {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Prototype");
        ConcretePrototype clone = (ConcretePrototype) original.clone();

        System.out.println("Original field: " + original.getField());
        System.out.println("Clone field: " + clone.getField());

        clone.setField("Modified Clone");

        System.out.println("Original field after modification: " + original.getField());
        System.out.println("Clone field after modification: " + clone.getField());
    }
}
