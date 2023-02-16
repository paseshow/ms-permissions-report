package com.paseshow.permissionsreport.dto.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoRespondeDto {
    Long id;
    String evento_nombre;
}
