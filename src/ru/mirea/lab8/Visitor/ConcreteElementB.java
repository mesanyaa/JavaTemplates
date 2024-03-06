package ru.mirea.lab8.Visitor;

// Конкретный элемент, который может быть посещен
class ConcreteElementB implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB() {
        System.out.println("Выполнение операции B");
    }
}