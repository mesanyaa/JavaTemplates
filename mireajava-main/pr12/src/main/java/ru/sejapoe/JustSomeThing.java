package ru.sejapoe;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JustSomeThing {
    private final Student student;

    @PostConstruct
    public void logStudent() {
        log.info(student.toString());
    }
}
