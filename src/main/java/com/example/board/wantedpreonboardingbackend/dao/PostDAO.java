package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.*;

import java.util.List;

public interface PostDAO {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);
    List<LoadedPostDTO> findAllPost(int page);
    LoadedPostDTO findPost(Long id);
    UpdatedPostDTO updatePost(Long id, UpdatePostDTO updatePostDTO);
}
