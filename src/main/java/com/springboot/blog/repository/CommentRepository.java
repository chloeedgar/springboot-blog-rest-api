package com.springboot.blog.repository;

import com.springboot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository is not required, @SimpleJpaRepository has the annotation
//it also has the @Transactional annotation
//@
//@SimpleJpaRepository which implements JpaRepositoryImplementation
//@JpaRepositoryImplementation extends JpaRepository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
