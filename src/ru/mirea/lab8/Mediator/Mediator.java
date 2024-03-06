package ru.mirea.lab8.Mediator;

// Интерфейс посредника
interface Mediator {
    void sendMessage(String message, Colleague colleague);
}
