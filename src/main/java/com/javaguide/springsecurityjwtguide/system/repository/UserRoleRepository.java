package com.javaguide.springsecurityjwtguide.system.repository;

import com.javaguide.springsecurityjwtguide.system.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
