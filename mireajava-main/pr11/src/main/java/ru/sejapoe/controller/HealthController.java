package ru.sejapoe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sejapoe.dto.HealthResponseDto;

@RestController
public class HealthController {
    @GetMapping("/health")
    public HealthResponseDto health() {
        return new HealthResponseDto("ok");
    }
}
