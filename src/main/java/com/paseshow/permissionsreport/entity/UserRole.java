package com.paseshow.permissionsreport.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class UserRole {
    private Long fkUser;
    private Long fkRole;
}
