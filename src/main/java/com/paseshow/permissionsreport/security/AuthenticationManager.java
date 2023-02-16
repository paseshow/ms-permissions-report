package com.paseshow.permissionsreport.security;

import com.paseshow.permissionsreport.service.UsuarioService;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private UsuarioService usuarioService;

    public AuthenticationManager(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return null;
    }
}
