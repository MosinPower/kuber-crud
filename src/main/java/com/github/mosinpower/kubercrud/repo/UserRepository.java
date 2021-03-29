package com.github.mosinpower.kubercrud.repo;

import com.github.mosinpower.kubercrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
