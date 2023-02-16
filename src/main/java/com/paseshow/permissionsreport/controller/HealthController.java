package com.paseshow.permissionsreport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HealthController {

    @GetMapping
    public Mono<ResponseEntity> health() {
        return Mono.just(ResponseEntity.ok().build());
    }
}
