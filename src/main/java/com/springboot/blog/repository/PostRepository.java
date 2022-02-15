package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository - this is not needed as it is included inside the JpaRepository
public interface PostRepository extends JpaRepository<Post, Long> {



}
