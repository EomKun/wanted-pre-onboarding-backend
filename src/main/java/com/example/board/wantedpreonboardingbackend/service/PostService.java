package com.example.board.wantedpreonboardingbackend.service;

import com.example.board.wantedpreonboardingbackend.dto.*;

import java.util.List;

public interface PostService {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);
    List<LoadedPostDTO> getAllPost(int page);
    LoadedPostDTO getPost(Long id);
    UpdatedPostDTO updatePost(Long id, UpdatePostDTO updatePostDTO);
}
