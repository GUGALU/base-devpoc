package com.polli.gustavo.devpoc.modules.user.repository;

import com.polli.gustavo.devpoc.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
