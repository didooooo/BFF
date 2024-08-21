package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.leaveAComment.LeaveACommentInputBff;
import com.tinqinacademy.comments.api.operations.leaveAComment.LeaveACommentInput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromBffToCommentsLeaveAComment implements Converter<LeaveACommentInputBff, LeaveACommentInput> {
    @Override
    public LeaveACommentInput convert(LeaveACommentInputBff source) {
        return LeaveACommentInput.builder()
                .birthdate(source.getBirthdate())
                .content(source.getContent())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .roomId(source.getRoomId())
                .build();
    }
}
