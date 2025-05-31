package com.hrishabh.quora.repository;

import com.hrishabh.quora.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
