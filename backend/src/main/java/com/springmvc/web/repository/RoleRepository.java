package com.springmvc.web.repository;

import com.springmvc.web.model.Role;
import com.springmvc.web.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
