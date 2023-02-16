package com.paseshow.permissionsreport.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EvolutionaryGraphsRequestDto {
    Long eventoId;
    Long fechaFuncion;
    Date from;
    Date to;
    String status;
}
