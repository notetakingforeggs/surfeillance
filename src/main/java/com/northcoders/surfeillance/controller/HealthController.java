package com.northcoders.surfeillance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("api/v1/health")
public class HealthController {

    @GetMapping
    public RedirectView apiHealth() {
        return new RedirectView("/actuator/health");
    }
}
