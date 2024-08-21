package com.tinqinacademy.bff.core.converters.comments;

import com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments.DataForGetListOFAllCommentBff;
import com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments.GetListOfAllCommentOutputBff;
import com.tinqinacademy.comments.api.operations.commentsGetListOfAllComments.DataForGetListOFAllComment;
import com.tinqinacademy.comments.api.operations.commentsGetListOfAllComments.GetListOfAllCommentOutput;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FromCommentsToBffGetListOfAllComments implements Converter<GetListOfAllCommentOutput, GetListOfAllCommentOutputBff> {
    @Override
    public GetListOfAllCommentOutputBff convert(GetListOfAllCommentOutput source) {
        List<DataForGetListOFAllCommentBff> data = getDataForGetListOFAllCommentBffs(source);
        return GetListOfAllCommentOutputBff.builder()
                .data(data)
                .build();
    }

    private @NotNull List<DataForGetListOFAllCommentBff> getDataForGetListOFAllCommentBffs(GetListOfAllCommentOutput source) {
        List<DataForGetListOFAllCommentBff> data = new ArrayList<>();
        for (DataForGetListOFAllComment datum : source.getData()) {
            data.add(
                    DataForGetListOFAllCommentBff.builder()
                            .id(datum.getId())
                            .firstName(datum.getFirstName())
                            .lastName(datum.getLastName())
                            .content(datum.getContent())
                            .publishDate(datum.getPublishDate())
                            .lastEditedDate(datum.getLastEditedDate())
                            .lastEditedBy(datum.getLastEditedBy())
                            .build()
            );
        }
        return data;
    }
}
