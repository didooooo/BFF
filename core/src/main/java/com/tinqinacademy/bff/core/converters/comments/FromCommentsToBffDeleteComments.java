package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.deleteComments.DeleteCommentsOutputBff;
import com.tinqinacademy.comments.api.operations.deleteComments.DeleteCommentsOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromCommentsToBffDeleteComments implements Converter<DeleteCommentsOutput, DeleteCommentsOutputBff> {
    @Override
    public DeleteCommentsOutputBff convert(DeleteCommentsOutput source) {
        return DeleteCommentsOutputBff.builder()
                .message(source.getMessage())
                .build();
    }
}
