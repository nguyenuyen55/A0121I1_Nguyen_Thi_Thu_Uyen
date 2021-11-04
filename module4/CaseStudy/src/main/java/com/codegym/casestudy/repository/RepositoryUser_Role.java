package com.codegym.casestudy.repository;

import com.codegym.casestudy.entity.Role;
import com.codegym.casestudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryUser_Role extends JpaRepository<User,String> {
    User getUserByUsername(String username);
@Query("select u.roles from User u where u.username = :username")
    List<Role> getRolesName(@Param("username") String username);
}
