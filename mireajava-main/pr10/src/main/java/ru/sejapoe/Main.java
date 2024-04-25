package ru.sejapoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// gradle :pr10:bootRun --args="boxer-fighter"
// gradle :pr10:bootRun --args="street-fighter"
//


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}