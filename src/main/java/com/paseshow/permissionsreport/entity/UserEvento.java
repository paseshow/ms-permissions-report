package com.paseshow.permissionsreport.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class UserEvento {
    private Long id;
    private String eventoNombre;
}
