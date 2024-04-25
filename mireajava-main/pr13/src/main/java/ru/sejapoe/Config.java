package ru.sejapoe;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FileProperties fileProperties(ApplicationArguments args) {
        String[] sourceFiles = args.getSourceArgs();
        if (sourceFiles.length < 2) {
            System.err.println("Usage: java -jar your_app.jar <inputFile> <outputFile>");
            System.exit(1);
        }
        return new FileProperties(sourceFiles[0], sourceFiles[1]);
    }
}
