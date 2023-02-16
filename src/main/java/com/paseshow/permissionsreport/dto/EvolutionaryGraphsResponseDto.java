package com.paseshow.permissionsreport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvolutionaryGraphsResponseDto {
    Long reservaFechaFacturacion;
    String reservaEstado;
    String reservaTipo;
    Long reservaId;
    Double reservaImporteTotal;
    Integer ubicacionEventoCount;
}

