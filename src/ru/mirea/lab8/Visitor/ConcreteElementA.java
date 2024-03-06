package ru.mirea.lab8.Visitor;

// Конкретный элемент, который может быть посещен
class ConcreteElementA implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("Выполнение операции A");
    }
}
