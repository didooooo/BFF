package com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments;

import com.tinqinacademy.bff.api.base.OperationOutput;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class GetListOfAllCommentOutputBff implements OperationOutput {
  private List<DataForGetListOFAllCommentBff> data;

    public GetListOfAllCommentOutputBff() {
        data= new ArrayList<>();
    }
}
