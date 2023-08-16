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

    /**
     * 게시물 등록 Request - Response
     */
    @PostMapping("/post")
    public ResponseEntity<InsertedPostDTO> createPost(@RequestBody @Valid InsertPostDTO insertPostDTO) {
        InsertedPostDTO insertedPostDTO = postService.insertPost(insertPostDTO);

        return ResponseEntity.status(HttpStatus.OK).body(insertedPostDTO);
    }

    /**
     * 게시물 목록 조희 Request - Response
     */
    @GetMapping("/post")
    public ResponseEntity<List<LoadedPostDTO>> getAllPost(
            @RequestParam
            @Min(value = 1, message = "page value must be greater than or equal to 1")
            Integer page) {
        List<LoadedPostDTO> postList = postService.getAllPost(page);

        return ResponseEntity.status(HttpStatus.OK).body(postList);
    }

    /**
     * id 기반 게시물 조회 Request - Response
     */
    @GetMapping("/post/{id}")
    public ResponseEntity<LoadedPostDTO> getPost(
            @PathVariable("id")
            @Min(value = 1, message = "id value must be greater than or equal to 1")
            Long id) {
        LoadedPostDTO post = postService.getPost(id);

        return ResponseEntity.status(HttpStatus.OK).body(post);
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
