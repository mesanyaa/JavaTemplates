package ru.mirea.lab7.Adapter;

// Адаптер, который позволяет использовать интерфейс Target с помощью Adaptee
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

