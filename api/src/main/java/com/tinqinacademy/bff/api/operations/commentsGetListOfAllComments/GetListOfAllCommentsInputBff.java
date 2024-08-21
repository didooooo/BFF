package com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments;

import com.tinqinacademy.bff.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetListOfAllCommentsInputBff implements OperationInput {
    private  String roomId;
}
