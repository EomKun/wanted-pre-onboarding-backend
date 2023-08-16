package com.example.board.wantedpreonboardingbackend.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 게시물 Entity
 *
 * id: 게시물 고유 id
 * title: 게시물 제목
 * content: 게시물 내용
 * writer: 작성자
 * attach: 첨부파일
 * views: 조회수
 * isCreated: 작성 일자
 * isUpdated: 수정 일자
 * isDeleted: 삭제된 게시글 여부
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String writer;

    private String attach;

    @Column(nullable = false)
    private long views;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDt;

    @Column(nullable = false)
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public long getViews() {
        return views;
    }

    public LocalDateTime getCreatedDt() {
        return createdDt;
    }

    public LocalDateTime getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
