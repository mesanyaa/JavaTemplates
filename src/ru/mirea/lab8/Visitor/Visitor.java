package ru.mirea.lab8.Visitor;

// Интерфейс посетителя
interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
