package ru.sejapoe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("street-fighter")
public class StreetFighter implements Fighter {
    @Override
    public void doFight() {
        log.info("Street Fighter do bah-bah");
    }
}
