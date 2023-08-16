package com.example.board.wantedpreonboardingbackend.validation;

import com.example.board.wantedpreonboardingbackend.dto.UpdatePostDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateValidator implements ConstraintValidator<UpdateDTOCheck, UpdatePostDTO> {
    private String msg;
    private String title;
    private String content;
    private String attach;

    @Override
    public void initialize(UpdateDTOCheck annotation) {
        msg = annotation.message();
        title = annotation.title();
        content = annotation.content();
        attach = annotation.attach();
    }

    @Override
    public boolean isValid(UpdatePostDTO updatePostDTO, ConstraintValidatorContext context) {
        String title = updatePostDTO.getTitle();
        String content = updatePostDTO.getContent();
        String attach = updatePostDTO.getAttach();

        int isCheckCnt = 0;

        if(title == null || title.isBlank()) isCheckCnt++;
        if(content == null || content.isBlank()) isCheckCnt++;
        if(attach == null || attach.isBlank()) isCheckCnt++;

        return isCheckCnt != 3;
    }
}
