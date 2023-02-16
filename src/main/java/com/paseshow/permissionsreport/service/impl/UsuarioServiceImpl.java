package com.paseshow.permissionsreport.service.impl;

import com.paseshow.permissionsreport.entity.User;
import com.paseshow.permissionsreport.entity.Role;
import com.paseshow.permissionsreport.entity.UserRole;
import com.paseshow.permissionsreport.repository.RoleRepository;
import com.paseshow.permissionsreport.repository.UserRoleRepository;
import com.paseshow.permissionsreport.repository.UsuarioRepository;
import com.paseshow.permissionsreport.service.UsuarioService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    private UserRoleRepository userRoleRepository;

    private RoleRepository roleRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              UserRoleRepository userRoleRepository,
                              RoleRepository roleRepository) {
        this.usuarioRepository = usuarioRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public Mono<User> findById(Long id) {
        return this.usuarioRepository.findById(id);
    }

    @Override
    public Flux<Role> findRoleById(Long userId) {
        return this.userRoleRepository.findByFkUser(userId)
                .map(UserRole::getFkRole)
                .flatMap(fkUser -> {
                    return this.roleRepository.findById(fkUser);
                });
    }
}
