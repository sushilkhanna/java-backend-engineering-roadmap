package org.demo.foreel.repository;

import org.demo.foreel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
    boolean existsByPhoneNo(String phoneNo);
}
