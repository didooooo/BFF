package com.tinqinacademy.bff.core.processors.comments;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentInputBff;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentOutputBff;
import com.tinqinacademy.bff.api.operations.editOwnComment.EditOwnCommentsOperation;
import com.tinqinacademy.comments.api.operations.editOwnComment.EditOwnCommentOutput;
import com.tinqinacademy.comments.restexport.RestExportComments;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EditOwnCommentProcessor implements EditOwnCommentsOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportComments restExportComments;

    public EditOwnCommentProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportComments restExportComments) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportComments = restExportComments;
    }

    @Override
    public Either<Errors, EditOwnCommentOutputBff> process(EditOwnCommentInputBff input) {
        return Try.of(() -> {
                    EditOwnCommentOutput editOwnCommentOutput = restExportComments.editOwnCommentOutput(String.valueOf(input.getId()), input.getContent());
                    return conversionService.convert(editOwnCommentOutput, EditOwnCommentOutputBff.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
