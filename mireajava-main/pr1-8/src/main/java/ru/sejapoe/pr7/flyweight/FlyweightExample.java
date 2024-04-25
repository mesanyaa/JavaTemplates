package ru.sejapoe.pr7.flyweight;

import java.util.HashMap;
import java.util.Map;

record Color(String name) {

}

interface Vehicle {

    Color color();
}

record ConcreteVehicle(Color color) implements Vehicle {
}

class VehicleFactory {
    private final Map<Color, Vehicle> vehicles = new HashMap<>();

    public Vehicle createVehicle(Color color) {
        return vehicles.computeIfAbsent(color, newColor -> new ConcreteVehicle(color));
    }
}

public class FlyweightExample {
    public static void main(String[] args) {
        var factory = new VehicleFactory();

        var redColor = new Color("RED");
        var blueColor = new Color("BLUE");

        var redVehicle1 = factory.createVehicle(redColor);
        var redVehicle2 = factory.createVehicle(redColor);
        var blueVehicle = factory.createVehicle(blueColor);
        System.out.println(redVehicle1);
        System.out.println(redVehicle2);
        System.out.println(blueVehicle);
        assert redVehicle1 == redVehicle2;
    }
}