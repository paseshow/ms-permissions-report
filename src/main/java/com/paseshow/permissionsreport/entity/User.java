package com.paseshow.permissionsreport.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Table
@Data
public class User {
    @Id
    @Column("PK_USER")
    private Long id;
    private String name;
    private String surname;
    private long dni;
    private String email;
    private String password;
    private int unenabled;
    private String descuentos;
}
