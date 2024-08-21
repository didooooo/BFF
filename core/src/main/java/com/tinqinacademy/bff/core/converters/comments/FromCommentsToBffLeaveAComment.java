package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.leaveAComment.LeaveACommentOutputBff;
import com.tinqinacademy.comments.api.operations.leaveAComment.LeaveACommentOutput;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FromCommentsToBffLeaveAComment implements Converter<LeaveACommentOutput, LeaveACommentOutputBff> {
    @Override
    public LeaveACommentOutputBff convert(LeaveACommentOutput source) {
        return LeaveACommentOutputBff.builder()
                .roomId(source.getRoomId())
                .build();
    }
}
