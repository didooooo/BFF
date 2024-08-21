package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.editCommentByAdmin.EditCommentsByAdminInputBff;
import com.tinqinacademy.comments.api.operations.editCommentByAdmin.EditCommentsByAdminInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToCommentsEditCommentByAdmin implements Converter<EditCommentsByAdminInputBff, EditCommentsByAdminInput> {
    @Override
    public EditCommentsByAdminInput convert(EditCommentsByAdminInputBff source) {
        return EditCommentsByAdminInput.builder()
                .commentId(source.getCommentId())
                .content(source.getContent())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .roomNo(source.getRoomNo())
                .build();
    }
}
