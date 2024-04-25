package ru.sejapoe.pr1;

import lombok.Builder;

import java.util.List;

@Builder
public record Student(
        String name,
        List<Grades> grades
) {
}
