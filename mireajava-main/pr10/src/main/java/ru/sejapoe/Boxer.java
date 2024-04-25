package ru.sejapoe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("boxer-fighter")
public class Boxer implements Fighter {
    @Override
    public void doFight() {
        log.info("Boxer do bonk");
    }
}
