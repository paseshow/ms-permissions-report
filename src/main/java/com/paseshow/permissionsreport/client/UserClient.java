package com.paseshow.permissionsreport.client;

import com.paseshow.permissionsreport.dto.evento.EventoRespondeDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserClient {
    Mono<ResponseEntity<Flux<EventoRespondeDto>>> getEventosByUser(Long idUser);
}
