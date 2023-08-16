package com.example.board.wantedpreonboardingbackend.service;

import com.example.board.wantedpreonboardingbackend.dao.PostDAO;
import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.LoadedPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostDAO postDAO;

    @Autowired
    public PostServiceImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public InsertedPostDTO insertPost(InsertPostDTO insertPostDTO) {
        return postDAO.insertPost(insertPostDTO);
    }

    @Override
    public List<LoadedPostDTO> getAllPost(int page) {
        return postDAO.findAllPost(page);
    }

    @Override
    public LoadedPostDTO getPost(Long id) {
        return postDAO.findPost(id);
    }
}
