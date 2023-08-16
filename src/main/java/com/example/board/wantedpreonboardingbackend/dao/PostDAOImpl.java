package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.*;
import com.example.board.wantedpreonboardingbackend.entity.Post;
import com.example.board.wantedpreonboardingbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

    @Override
    public LoadedPostDTO findPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("[id : " + id + "] There are no posts matching the id"));

        return new LoadedPostDTO(post.getId(), post.getTitle(), post.getContent(),
                post.getWriter(), post.getViews(), post.getCreatedDt());
    }

    @Override
    public UpdatedPostDTO updatePost(Long id, UpdatePostDTO updatePostDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("[id : " + id + "] There are no posts matching the id"));
        if(updatePostDTO.getTitle() != null && !updatePostDTO.getTitle().isBlank()) post.setTitle(updatePostDTO.getTitle());
        if(updatePostDTO.getContent() != null && !updatePostDTO.getContent().isBlank()) post.setContent(updatePostDTO.getContent());
        if(updatePostDTO.getAttach() != null && !updatePostDTO.getAttach().isBlank()) post.setAttach(updatePostDTO.getAttach());
        post.setUpdatedDt(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        postRepository.save(post);

        return new UpdatedPostDTO(post.getTitle(), post.getContent(),
                post.getWriter(), post.getAttach(), post.getViews(), post.getUpdatedDt());
    }
}
