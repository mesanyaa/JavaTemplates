package ru.mirea.lab7.Facade;

// Фасад - обеспечивает простой интерфейс для сложной системы классов
class Facade {
    private OperationA operationA;
    private OperationB operationB;
    private OperationC operationC;

    public Facade() {
        this.operationA = new OperationA();
        this.operationB = new OperationB();
        this.operationC = new OperationC();
    }

    // Методы фасада, скрывающие сложность системы
    public void operationAB() {
        operationA.operation();
        operationB.operation();
    }

    public void operationBC() {
        operationB.operation();
        operationC.operation();
    }
}
