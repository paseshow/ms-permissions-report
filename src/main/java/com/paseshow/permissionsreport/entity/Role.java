package com.paseshow.permissionsreport.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Role {

    @Id
    private Long pkRole;
    private String name;
}
