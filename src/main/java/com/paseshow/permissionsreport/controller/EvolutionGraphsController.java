package com.paseshow.permissionsreport.controller;

import com.paseshow.permissionsreport.client.EvolutionGraphsClient;
import com.paseshow.permissionsreport.commons.Logger;
import com.paseshow.permissionsreport.commons.Utils;
import com.paseshow.permissionsreport.dto.EvolutionaryGraphsRequestDto;
import com.paseshow.permissionsreport.dto.EvolutionaryGraphsResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/evolutionary-graphs")
@CrossOrigin
public class EvolutionGraphsController {

    private String className = this.getClass().getName();
    private EvolutionGraphsClient evolutionGraphsClient;

    public EvolutionGraphsController(EvolutionGraphsClient evolutionGraphsClient) {
        this.evolutionGraphsClient = evolutionGraphsClient;
    }

    @PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN', 'ROLE_PRODUCTOR')")
    @PostMapping()
    public Mono<ResponseEntity<Flux<EvolutionaryGraphsResponseDto>>> getByDates(@RequestBody EvolutionaryGraphsRequestDto evolutionaryGraphsRequest) {
        Logger.LogInfo(this.className, "getByDates", Utils.LOG_INIT);

        return this.evolutionGraphsClient.getByDates(evolutionaryGraphsRequest)
                .map(fluxResponseEntity -> fluxResponseEntity )
                .doOnNext(sectorEventoDto -> Logger.LogInfo(this.className, "getByDates", Utils.LOG_END_OK));
    }
}
