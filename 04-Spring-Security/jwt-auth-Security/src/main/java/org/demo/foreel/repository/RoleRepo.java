package org.demo.foreel.repository;

import org.demo.foreel.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    RoleRepo findByName(String name);
}
