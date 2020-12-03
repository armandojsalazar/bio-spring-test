package com.codeup.blog.repos;


import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
