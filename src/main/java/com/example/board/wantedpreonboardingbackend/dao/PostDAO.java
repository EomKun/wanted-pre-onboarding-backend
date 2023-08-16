package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.LoadedPostDTO;

import java.util.List;

public interface PostDAO {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);
    List<LoadedPostDTO> findAllPost(int page);
    LoadedPostDTO findPost(Long id);
}
