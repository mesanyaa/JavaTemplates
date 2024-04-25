package ru.sejapoe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component("judoka-fighter")
public class Judoka implements Fighter {
    @Override
    public void doFight() {
        log.info("Judoka do ki-yah");
    }
}
