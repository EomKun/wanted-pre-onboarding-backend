package com.example.board.wantedpreonboardingbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @GetMapping("/test")
    public String Hello() {
        return "Hello, world!";
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
