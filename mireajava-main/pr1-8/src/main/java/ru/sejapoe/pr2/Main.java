package ru.sejapoe.pr2;

import me.xdrop.jrand.JRand;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static Human generateHuman() {
        Instant birthDate = Instant.ofEpochMilli(
                JRand.decimal()
                        .min(Instant.now().minus(30 * 365, ChronoUnit.DAYS).toEpochMilli())
                        .max(Instant.now().toEpochMilli())
                        .genAsDecimal().longValue()
        );
        return new Human(
                Math.toIntExact(ChronoUnit.DAYS.between(birthDate, Instant.now())) / 365,
                JRand.firstname().gen(),
                JRand.lastname().gen(),
                LocalDate.ofInstant(birthDate, ZoneId.systemDefault()),
                JRand.decimal().min(50).max(150).genAsDecimal().intValue()
        );
    }

    public static void main(String[] args) {
        List<Human> humans = Stream.generate(Main::generateHuman).limit(20).toList();


        System.out.println(humans);

        String result = humans.stream()
                .peek(human -> human.setWeight(human.getWeight() - 5))
                .filter(human -> human.getBirthDate().isBefore(LocalDate.of(1999, 2, 3)))
                .map(Human::getLastName)
                .collect(Collectors.joining(" "));

        System.out.println(result);


        // debug information
        System.out.println(humans);
    }
}
