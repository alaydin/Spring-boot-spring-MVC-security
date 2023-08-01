package com.demo.springboot.demosecurity.repository;

import com.demo.springboot.demosecurity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends JpaRepository<Member, String> {
}
