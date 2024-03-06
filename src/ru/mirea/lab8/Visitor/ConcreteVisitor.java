package ru.mirea.lab8.Visitor;

// Конкретный посетитель, выполняющий операции над элементами
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        elementA.operationA();
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        elementB.operationB();
    }
}