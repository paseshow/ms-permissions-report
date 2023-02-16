package com.paseshow.permissionsreport.service;

import com.paseshow.permissionsreport.entity.User;
import com.paseshow.permissionsreport.entity.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsuarioService {
    Mono<User> findById(Long id);

    Flux<Role> findRoleById(Long userId);
}
