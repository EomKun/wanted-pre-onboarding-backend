package com.example.board.wantedpreonboardingbackend.controller;

import com.example.board.wantedpreonboardingbackend.dto.InsertPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.InsertedPostDTO;
import com.example.board.wantedpreonboardingbackend.dto.LoadedPostDTO;
import com.example.board.wantedpreonboardingbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/board")
@Validated
public class BoardController {
    private final PostService postService;

    @Autowired
    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<InsertedPostDTO> createPost(@RequestBody @Valid InsertPostDTO insertPostDTO) {
        InsertedPostDTO insertedPostDTO = postService.insertPost(insertPostDTO);

        return ResponseEntity.status(HttpStatus.OK).body(insertedPostDTO);
    }

    @GetMapping("/post")
    public ResponseEntity<List<LoadedPostDTO>> getAllPost(
            @RequestParam
            @Min(value = 1, message = "page value must be greater than or equal to 1")
            Integer page) {
        List<LoadedPostDTO> postList = postService.getAllPost(page);

        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

    /**
     * 게시판에 관련된 요청을 받아 처리하는 부분
     *
     * 1. 새로운 게시글을 생성하는 엔드포인트
     * 2. 게시글 목록을 조회하는 엔드포인트
     * 3. 특정 게시글을 조회하는 엔드포인트
     * 4. 특정 게시글을 수정하는 엔드포인트
     * 5. 특정 게시글을 삭제하는 엔드포인트
     *
     * 5가지의 구현이 필요합니다.
     */
}
