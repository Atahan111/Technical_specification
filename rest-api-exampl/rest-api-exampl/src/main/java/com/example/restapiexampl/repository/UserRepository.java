package com.example.restapiexampl.repository;

import com.example.restapiexampl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
