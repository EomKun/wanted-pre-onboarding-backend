package com.example.board.wantedpreonboardingbackend.service;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;

public interface PostService {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);
}
