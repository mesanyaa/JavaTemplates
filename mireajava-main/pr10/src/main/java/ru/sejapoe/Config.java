package ru.sejapoe;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Config {
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String arg = args[0];
            log.info(arg);

            Fighter fighter = ctx.getBean(arg, Fighter.class);
            fighter.doFight();
        };
    }
}
