package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.LoadedPostDTO;
import com.example.board.wantedpreonboardingbackend.entity.Post;
import com.example.board.wantedpreonboardingbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public List<LoadedPostDTO> findAllPost(int page) {
        Page<Post> postPage = postRepository.findAllByOrderByCreatedDtDesc(PageRequest.of(page-1, 10));

        return postPage.map((p) -> new LoadedPostDTO(p.getId(), p.getTitle(), p.getContent(),
                p.getWriter(), p.getViews(), p.getCreatedDt())).toList();
    }
}