package com.codeup.blog.repos;

import com.codeup.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Long> {
    Post findByTitle(String title); // select * from ads where title = ?
    Post findFirstByTitle(String title); // select * from ads where title = ? limit 1
    Post deleteById(long id);
}
