package com.jaya.springMVC_learning.repositories;

import com.jaya.springMVC_learning.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
