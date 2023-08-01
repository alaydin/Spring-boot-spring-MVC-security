package com.demo.springboot.demosecurity.repository;

import com.demo.springboot.demosecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, String> {
}
