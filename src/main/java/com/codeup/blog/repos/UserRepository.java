package com.codeup.blog.repos;


import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
    User findByEmail(String email);
}
