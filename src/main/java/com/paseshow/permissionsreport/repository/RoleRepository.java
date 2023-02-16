package com.paseshow.permissionsreport.repository;

import com.paseshow.permissionsreport.entity.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {
}
