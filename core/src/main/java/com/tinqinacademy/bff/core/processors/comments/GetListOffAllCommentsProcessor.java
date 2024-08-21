package com.tinqinacademy.bff.core.processors.comments;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments.GetListOfAllCommentOutputBff;
import com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments.GetListOfAllCommentsInputBff;
import com.tinqinacademy.bff.api.operations.commentsGetListOfAllComments.GetListOfAllCommentsOperation;
import com.tinqinacademy.comments.api.operations.commentsGetListOfAllComments.GetListOfAllCommentOutput;
import com.tinqinacademy.comments.restexport.RestExportComments;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetListOffAllCommentsProcessor implements GetListOfAllCommentsOperation {
    private final ErrorMapper errorMapper;
    private final RestExportComments restExportComments;
    private final ConversionService conversionService;

    public GetListOffAllCommentsProcessor(ErrorMapper errorMapper, RestExportComments restExportComments, ConversionService conversionService) {
        this.errorMapper = errorMapper;
        this.restExportComments = restExportComments;
        this.conversionService = conversionService;
    }

    @Override
    public Either<Errors, GetListOfAllCommentOutputBff> process(GetListOfAllCommentsInputBff input) {
        return Try.of(() -> {
                    GetListOfAllCommentOutput listOfAllCommentOutputs = restExportComments.getListOfAllCommentOutputs(input.getRoomId());
                    return conversionService.convert(listOfAllCommentOutputs,GetListOfAllCommentOutputBff.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
