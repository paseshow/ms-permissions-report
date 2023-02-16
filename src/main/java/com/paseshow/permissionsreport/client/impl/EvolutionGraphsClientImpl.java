package com.paseshow.permissionsreport.client.impl;

import com.paseshow.permissionsreport.client.EvolutionGraphsClient;
import com.paseshow.permissionsreport.commons.Logger;
import com.paseshow.permissionsreport.dto.EvolutionaryGraphsRequestDto;
import com.paseshow.permissionsreport.dto.EvolutionaryGraphsResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EvolutionGraphsClientImpl implements EvolutionGraphsClient {

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
    public Mono<ResponseEntity<Flux<EvolutionaryGraphsResponseDto>>> getByDates(EvolutionaryGraphsRequestDto evolutionaryGraphsRequestDto) {
        String url = "evolutionary-graphs";
        Logger.LogInfo("URL: ".concat(this.hostMsReporte.concat(url)));

        return this.webClientCreate().post()
                .uri(uriBuilder -> uriBuilder
                        .path(url)
                        .build())
                .body(BodyInserters.fromValue(evolutionaryGraphsRequestDto))
                .retrieve()
                .toEntityFlux(EvolutionaryGraphsResponseDto.class)
                .doOnNext(fluxResponseEntity -> Logger.LoggerResponseEntity(fluxResponseEntity, HttpMethod.POST))
                .doOnError(throwable -> Logger.LoggerResponseEntityError(throwable, HttpMethod.POST));
    }
}
