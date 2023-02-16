package com.paseshow.permissionsreport.repository;

import com.paseshow.permissionsreport.entity.UserRole;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRoleRepository extends ReactiveCrudRepository<UserRole, Long> {
    Flux<UserRole> findByFkUser(Long kfUser);
}
