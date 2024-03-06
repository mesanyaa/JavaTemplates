package ru.mirea.lab8.Visitor;

// Интерфейс для элементов, которые могут быть посещены
interface Visitable {
    void accept(Visitor visitor);
}
