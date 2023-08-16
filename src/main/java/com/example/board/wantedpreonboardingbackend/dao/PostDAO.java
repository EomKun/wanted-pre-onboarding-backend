package com.example.board.wantedpreonboardingbackend.dao;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;

public interface PostDAO {
    InsertedPostDTO insertPost(InsertPostDTO insertPostDTO);

}
