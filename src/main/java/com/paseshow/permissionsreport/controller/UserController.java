package com.paseshow.permissionsreport.controller;

import com.paseshow.permissionsreport.client.UserClient;
import com.paseshow.permissionsreport.commons.Logger;
import com.paseshow.permissionsreport.commons.Utils;
import com.paseshow.permissionsreport.dto.evento.EventoRespondeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private String className = this.getClass().getName();

    private UserClient userClient;
    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_PRODUCTOR')")
    @GetMapping("/eventos")
    public Mono<ResponseEntity<Flux<EventoRespondeDto>>> getEventosByUser() {
        Logger.LogInfo(this.className, "getEventosByUser", Utils.LOG_INIT);

        return ReactiveSecurityContextHolder.getContext()
                .flatMap(securityContext -> {
                    Long idUser = (Long) securityContext.getAuthentication().getPrincipal();
                    return this.userClient.getEventosByUser(idUser)
                            .doOnNext(eventosByUser -> Logger.LogInfo(this.className, "getEventosByUser", Utils.LOG_END_OK));
                });
    };
}
