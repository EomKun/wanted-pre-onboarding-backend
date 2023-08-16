package com.example.board.wantedpreonboardingbackend.repository;

import com.example.board.wantedpreonboardingbackend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByOrderByCreatedDtDesc(PageRequest createdDt);
}
