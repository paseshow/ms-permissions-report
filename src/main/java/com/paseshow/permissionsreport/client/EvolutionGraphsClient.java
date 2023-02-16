package com.paseshow.permissionsreport.client;

import com.paseshow.permissionsreport.dto.EvolutionaryGraphsRequestDto;
import com.paseshow.permissionsreport.dto.EvolutionaryGraphsResponseDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EvolutionGraphsClient {
    Mono<ResponseEntity<Flux<EvolutionaryGraphsResponseDto>>> getByDates(EvolutionaryGraphsRequestDto evolutionaryGraphsRequestDto);
}
