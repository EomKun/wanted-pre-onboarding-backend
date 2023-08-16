package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.entity.Post;
import com.example.board.wantedpreonboardingbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDAOImpl implements PostDAO {
    private final PostRepository postRepository;

    @Autowired
    public PostDAOImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public InsertedPostDTO insertPost(InsertPostDTO insertPostDTO) {
        Post post = new Post();

        post.setTitle(insertPostDTO.getTitle());
        post.setContent(insertPostDTO.getContent());
        post.setAttach(insertPostDTO.getAttach());
        post.setWriter(insertPostDTO.getWriter());

        postRepository.save(post);

        return new InsertedPostDTO(post.getTitle(), post.getContent(), post.getWriter(),
                post.getAttach(), post.getViews(), post.getCreatedDt());
    }
}
