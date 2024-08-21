package com.tinqinacademy.bff.core.processors.comments;

import com.tinqinacademy.bff.api.exceptions.ErrorMapper;
import com.tinqinacademy.bff.api.exceptions.Errors;
import com.tinqinacademy.bff.api.operations.deleteComments.DeleteCommentsInputBff;
import com.tinqinacademy.bff.api.operations.deleteComments.DeleteCommentsOperation;
import com.tinqinacademy.bff.api.operations.deleteComments.DeleteCommentsOutputBff;
import com.tinqinacademy.comments.api.operations.deleteComments.DeleteCommentsOutput;
import com.tinqinacademy.comments.restexport.RestExportComments;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeleteCommentsProcessor implements DeleteCommentsOperation {
    private final ErrorMapper errorMapper;
    private final ConversionService conversionService;
    private final RestExportComments restExportComments;

    public DeleteCommentsProcessor(ErrorMapper errorMapper, ConversionService conversionService, RestExportComments restExportComments) {
        this.errorMapper = errorMapper;
        this.conversionService = conversionService;
        this.restExportComments = restExportComments;
    }

    @Override
    public Either<Errors, DeleteCommentsOutputBff> process(DeleteCommentsInputBff input) {
        return Try.of(() -> {
                    DeleteCommentsOutput deleteCommentsOutput = restExportComments.deleteCommentsOutput(input.getCommentId());
                    return conversionService.convert(deleteCommentsOutput, DeleteCommentsOutputBff.class);
                }).toEither()
                .mapLeft(errorMapper::mapError);
    }
}
