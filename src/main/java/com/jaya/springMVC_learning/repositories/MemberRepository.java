package com.jaya.springMVC_learning.repositories;

import com.jaya.springMVC_learning.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByUsername(String username);
}
