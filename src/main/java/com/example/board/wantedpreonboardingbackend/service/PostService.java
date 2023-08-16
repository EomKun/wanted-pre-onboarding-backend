package com.example.board.wantedpreonboardingbackend.service;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.LoadedPostDTO;

import java.util.List;

public interface PostService {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);
    List<LoadedPostDTO> getAllPost(int page);
}
