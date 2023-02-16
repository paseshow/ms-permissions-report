package com.paseshow.permissionsreport.client.impl;

import com.paseshow.permissionsreport.client.UserClient;
import com.paseshow.permissionsreport.commons.Logger;
import com.paseshow.permissionsreport.dto.evento.EventoDto;
import com.paseshow.permissionsreport.dto.evento.EventoRespondeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserClientImpl implements UserClient {
    @Value("${host.ms-reporte}")
    private String hostMsReporte;

    public WebClient webClientCreate() {
        return WebClient.builder()
                .baseUrl(this.hostMsReporte)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public Mono<ResponseEntity<Flux<EventoRespondeDto>>> getEventosByUser(Long idUser) {
        String url = String.format("user/%s/eventos", idUser);
        Logger.LogInfo("URL: ".concat(this.hostMsReporte.concat(url)));

        return this.webClientCreate().get()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .build())
                .retrieve()
                .toEntityFlux(EventoRespondeDto.class)
                .doOnNext(fluxResponseEntity -> Logger.LoggerResponseEntity(fluxResponseEntity, HttpMethod.GET))
                .doOnError(throwable -> Logger.LoggerResponseEntityError(throwable, HttpMethod.GET));
    }
}
