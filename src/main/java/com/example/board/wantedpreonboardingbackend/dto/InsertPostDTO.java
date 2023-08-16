package com.example.board.wantedpreonboardingbackend.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class InsertPostDTO {
    @NotBlank(message = "title is blank")
    private String title;

    @NotBlank(message = "content is blank")
    private String content;
    private String attach;

    @NotBlank(message = "writer isn't exist")
    @Email
    private String writer;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAttach() {
        return attach;
    }

    public String getWriter() {
        return writer;
    }
}
