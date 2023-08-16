package com.example.board.wantedpreonboardingbackend.dto;

import com.example.board.wantedpreonboardingbackend.validation.UpdateDTOCheck;

@UpdateDTOCheck(title = "title", content = "content", attach = "attach")
public class UpdatePostDTO {
    private String title;
    private String content;
    private String attach;

    public UpdatePostDTO() {}

    public UpdatePostDTO(String title, String content, String attach) {
        this.title = title;
        this.content = content;
        this.attach = attach;
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

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }
}
