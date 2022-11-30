package com.example.starthomework.Repository;

import com.example.starthomework.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();

    Optional<Object> findByIdAndPassword(Long id, String password);
}
