package com.paseshow.permissionsreport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/")
public class HealthController {

    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @GetMapping
    public Mono<ResponseEntity> health() {
        return Mono.just(ResponseEntity.ok().build());
    }
}
