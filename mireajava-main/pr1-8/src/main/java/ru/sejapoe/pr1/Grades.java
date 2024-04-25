package ru.sejapoe.pr1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Grades {
    SUPER("Отлично", "отл", 5),
    GOOD("Хорошо", "хор", 4),
    OKAY("Удовлетворительно", "удов", 3),
    FAIL("Неудовлетворительно", "неуд", 2);

    private final String fullName;
    private final String shortName;
    private final int numberRepresentation;
}
