package ru.sejapoe;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "student")
public record Student(
        String name,
        String lastName,
        String group
) {
}
