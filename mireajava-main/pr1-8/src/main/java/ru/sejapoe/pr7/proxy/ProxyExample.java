
package ru.sejapoe.pr7.proxy;

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}

class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        System.out.println("Proxy: Handling request.");
        if (realSubject == null) {
            System.out.println("Proxy: Creating RealSubject.");
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}

public class ProxyExample {
    public static void main(String[] args) {
        Subject proxy = new Proxy();

        proxy.request();
        proxy.request();
    }
}
