package com.paseshow.permissionsreport.repository;

import com.paseshow.permissionsreport.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ReactiveCrudRepository<User, Long> {
}
