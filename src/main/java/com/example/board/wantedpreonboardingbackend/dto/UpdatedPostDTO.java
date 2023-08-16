package com.example.board.wantedpreonboardingbackend.dto;

import java.time.LocalDateTime;

public class UpdatedPostDTO {
    private String title;
    private String content;
    private String writer;
    private String attach;
    private long views;
    private LocalDateTime updatedDt;

    public UpdatedPostDTO(String title, String content, String writer, String attach, long views, LocalDateTime updatedDt) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.attach = attach;
        this.views = views;
        this.updatedDt = updatedDt;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getAttach() {
        return attach;
    }

    public long getViews() {
        return views;
    }

    public LocalDateTime getUpdatedDt() {
        return updatedDt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public void setUpdatedDt(LocalDateTime updatedDt) {
        this.updatedDt = updatedDt;
    }
}
