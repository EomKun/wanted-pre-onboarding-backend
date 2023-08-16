package com.example.board.wantedpreonboardingbackend.dto;

import java.time.LocalDateTime;

public class LoadedPostDTO {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private long views;

    private LocalDateTime CreatedDt;

    public LoadedPostDTO() {}
    public LoadedPostDTO(Long id, String title, String content, String writer, long views, LocalDateTime createdDt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.views = views;
        CreatedDt = createdDt;
    }

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

    public long getViews() {
        return views;
    }

    public LocalDateTime getCreatedDt() {
        return CreatedDt;
    }
}
