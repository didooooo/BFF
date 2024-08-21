package com.tinqinacademy.bff.api.operations.leaveAComment;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LeaveACommentOutputBff implements OperationOutput {
    private String roomId;
    
}
