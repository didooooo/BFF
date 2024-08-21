package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentOutputBff;
import com.tinqinacademy.comments.api.operations.editOwnComment.EditOwnCommentOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromCommentsToBffEditOwnComment implements Converter<EditOwnCommentOutput, EditOwnCommentOutputBff> {
    @Override
    public EditOwnCommentOutputBff convert(EditOwnCommentOutput source) {
        return EditOwnCommentOutputBff.builder()
                .id(source.getId())
                .build();
    }
}
