package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.editCommentByAdmin.EditCommentsByAdminOutputBff;
import com.tinqinacademy.comments.api.operations.editCommentByAdmin.EditCommentsByAdminOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromCommentsToBffEditCommentsByAdmin implements Converter<EditCommentsByAdminOutput, EditCommentsByAdminOutputBff> {
    @Override
    public EditCommentsByAdminOutputBff convert(EditCommentsByAdminOutput source) {
        return EditCommentsByAdminOutputBff.builder()
                .id(source.getId())
                .build();
    }
}
