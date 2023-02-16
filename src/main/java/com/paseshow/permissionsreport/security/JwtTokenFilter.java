package com.paseshow.permissionsreport.security;

import com.paseshow.permissionsreport.service.UsuarioService;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

public class JwtTokenFilter implements WebFilter {

    private UsuarioService usuarioService;

    private JwtProvider jwtProvider;

    public JwtTokenFilter(UsuarioService usuarioService, JwtProvider jwtProvider) {
        this.usuarioService = usuarioService;
        this.jwtProvider = jwtProvider;
    }

    private String getToken(ServerHttpRequest request) {
        String bearerToken = request.getHeaders().getFirst("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String token = getToken(exchange.getRequest());

        if(token == null)
            return chain.filter(exchange);

        Long userId = this.jwtProvider.getUserIdFromJWT(token);

        if(!StringUtils.hasText(token) && !this.jwtProvider.validToken(token))
            return chain.filter(exchange);

        return this.usuarioService.findById(userId)
                .flatMap(appUser -> {
                    return this.usuarioService.findRoleById(appUser.getId())
                            .collectList()
                            .flatMap(roles -> {
                                List<GrantedAuthority> authorities = roles.stream().map(rol -> new SimpleGrantedAuthority(
                                        rol.getName())).collect(Collectors.toList());

                                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(appUser.getId(), appUser.getPassword(), authorities);

                                return chain.filter(exchange).contextWrite(a -> ReactiveSecurityContextHolder.withAuthentication(auth));
                            });
                });
    }
}
